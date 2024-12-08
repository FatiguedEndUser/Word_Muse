package com.example.word_muse


import com.example.word_muse.models.DictionaryDataItem
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiService{
    //Async
    @GET("en/")
    suspend fun search(
        @Query("Word") word: String? = null
    ): List<DictionaryDataItem>
}


