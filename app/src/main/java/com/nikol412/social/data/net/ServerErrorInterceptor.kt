package com.nikol412.social.data.net

import com.google.gson.Gson
import com.nikol412.social.domain.net.models.exceptions.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.net.HttpURLConnection
import java.net.UnknownHostException

class ServerErrorInterceptor : Interceptor, KoinComponent {

    private val gson: Gson by inject()

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            val response = chain.proceed(chain.request())
            if (response.isSuccessful.not()) {
                val json = if (response.body != null && response.body!!.contentLength() > 0) {
                    gson.toJson(response.body)
                } else {
                    null
                }
                when (response.code) {
                    HttpURLConnection.HTTP_BAD_REQUEST -> {
//                        throw ServerErrorException()
                    }
                }
            }
            return response
        } catch (ex: Exception) {
            if (ex is UnknownHostException) throw NoInternetException() else throw ex
        }
    }
}