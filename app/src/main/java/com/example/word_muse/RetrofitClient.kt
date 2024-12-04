package com.example.word_muse

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitClient {
    private val URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
    private val logging = HttpLogginInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient = OkHttpClient.Builder
        .addInterceptor(logging)
        .build()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    val searchApiService: SearchApiService by lazy{
        Retrofit.Builder()
    }
}