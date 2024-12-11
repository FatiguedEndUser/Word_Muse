package com.example.word_muse.API


import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService{
    //Async
    @GET("en/")
    suspend fun search(
        @Query("<YOUR_WORD>") word: String? = null
    ): List<DictionaryDataItem>
}


