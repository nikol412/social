package com.nikol412.social.di

import android.content.Context
import com.google.gson.Gson
import com.nikol412.social.data.net.AuthorizationInterceptor
import com.nikol412.social.data.net.ServerErrorInterceptor
import com.nikol412.social.data.net.repositories.FeedRepository
import com.nikol412.social.data.net.repositories.IFeedRepository
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

private const val BASE_URL = ""
//todo replace base url

fun provideDataModule() = module {
    single { Gson() }
    provideRetrofit()
    provideNetRepositories()
}

private fun Module.provideRetrofit() {
    single {
        val logs = get<HttpLoggingInterceptor>()
        val errors = get<ServerErrorInterceptor>()
        val auth = get<AuthorizationInterceptor>()
        createRetrofit(get(), BASE_URL, logs, errors, auth)
    }
}

private fun createRetrofit(
    context: Context,
    baseUrl: String,
    vararg interceptors: Interceptor
): Retrofit {
    val okHttpClient = createOkHttpClient(context, *interceptors)
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun createOkHttpClient(context: Context, vararg interceptors: Interceptor): OkHttpClient {
    val file = File(context.cacheDir, "http")
    val cache = Cache(file, 50 * 1024 * 1024)
    return OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .cache(cache)
        .apply { interceptors.forEach { addInterceptor(it) } }
        .build()
}

private fun Module.provideNetRepositories() {
    single<IFeedRepository> { FeedRepository(get()) }
}