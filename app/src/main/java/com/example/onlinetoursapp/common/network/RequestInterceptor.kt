package com.example.onlinetoursapp.common.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d("network", "Add headers in request")
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Token token=7f0185a09ec234cf0c2662a14d6e6fcf")

        return chain.proceed(request.build())
    }
}