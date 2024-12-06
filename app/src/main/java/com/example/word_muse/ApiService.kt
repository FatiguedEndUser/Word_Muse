package com.example.word_muse

import retrofit2.http.GET

interface SearchApiService{
    //Async
    @GET("en/")
    suspend fun search(query: String): List<String>
}


