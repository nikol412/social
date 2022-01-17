package com.nikol412.social.data.net

import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(
//    private val authorizationInteractor: IAuthorizationInteractor
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        runBlocking {
//            val token = authorizationInteractor.getAuthToken()
//            if (token.isNotEmpty()) builder.addHeader("Authorization", "Bearer $token")
//            Log.i("OkHTTP", "Token: $token")
            //todo implement this
        }
        return chain.proceed(builder.build())
    }

}