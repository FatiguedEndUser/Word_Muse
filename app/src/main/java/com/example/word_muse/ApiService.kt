package com.example.word_muse

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET


private val URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(URL)
    .build()


interface SearchApiService{
    @GET("word")
    fun search(query: String): String
}

public object DictionaryAPI{
    val retrofitService: SearchApiService by lazy {
        retrofit.create(SearchApiService::class.java)
    }
}


