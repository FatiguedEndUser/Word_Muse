// Repo/Helper functions/DB

package com.example.word_muse.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.word_muse.RetrofitClient
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    //State
    private lateinit var searchState: SearchState

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text

    private val _wordData = MutableLiveData("No Data")
    val wordData: LiveData<String> get() = _wordData

    init {
        viewModelScope.launch {
            getSearch()
        }
    }
//  TODO: Figure out how to append the word to the end of the endpoint for the api call.
//        pretty sure the app is crashing because the endpoint is pointing to en/
//        we need too follow up with that and attach
    private suspend fun getSearch(word: String? = null){

        _wordData.value = RetrofitClient.searchApiService.search().toString()
    }
}