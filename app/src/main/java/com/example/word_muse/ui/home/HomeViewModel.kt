// Repo/Helper functions/DB

package com.example.word_muse.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.word_muse.API.RetrofitClient

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text

    private val _wordData = MutableLiveData("No Data")
    val wordData: LiveData<String> get() = _wordData

//    THIS CRASHES THE PROGRAM
//    We need to call the getSearch function from the searchview
//    init {
//        viewModelScope.launch {
//            getSearch()
//        }
//    }


//  TODO: Figure out how to append the word to the end of the endpoint for the api call.
//        we need too follow up with that and attach
    suspend fun getSearch(word: String? = null){
        _wordData.value = RetrofitClient.searchApiService.search(word).toString()
    }
}