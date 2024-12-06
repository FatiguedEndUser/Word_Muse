package com.example.word_muse


import com.example.word_muse.models.DictionaryDataItem
import retrofit2.http.GET

interface SearchApiService{
    //Async
    @GET("en/")
    suspend fun search(): List<DictionaryDataItem>
}


