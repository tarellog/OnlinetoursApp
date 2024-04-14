package com.example.onlinetoursapp.common.application.di

import android.util.Log
import com.example.onlinetoursapp.common.network.RequestInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit

private const val URL = "https://www.onlinetours.ru/api/v2/public/"

@Module
class NetworkModule {

    @ApplicationScope
    @Provides
    fun provideJson(): Json {
        return Json { ignoreUnknownKeys = true }
    }

    @ApplicationScope
    @Provides
    fun provideConvertJson(json: Json): Converter.Factory {
        val contentType = "application/json".toMediaType()
        return json.asConverterFactory(contentType)
    }

    @ApplicationScope
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { message: String? -> Log.d("network", "LOG_BASIC $message") }
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)

    @ApplicationScope
    @Provides
    fun provideRequestInterceptor() = RequestInterceptor()

    @ApplicationScope
    @Provides
    fun provideOkHttpClient(
        requestInterceptor: RequestInterceptor,
        httpLogInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(httpLogInterceptor)
            .build()

    @ApplicationScope
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        kotlinConverterFactory: Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .client(okHttpClient)
        .addConverterFactory(kotlinConverterFactory)
        .build()

}