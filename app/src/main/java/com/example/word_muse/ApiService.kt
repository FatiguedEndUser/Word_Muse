package com.example.word_muse


import com.example.word_muse.models.DictonaryDataItem
import retrofit2.http.GET

interface SearchApiService{
    //Async
    @GET("en/")
    suspend fun search(): List<DictonaryDataItem>
}


