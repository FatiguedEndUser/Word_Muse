// Repo/Helper functions/DB

package com.example.word_muse.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.word_muse.RetrofitClient
import kotlinx.coroutines.launch

sealed interface SearchState{
    data class Success(val word: String): SearchState
    object Error: SearchState
    object Loading: SearchState
}

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

    private suspend fun getSearch(){
        _wordData.value = RetrofitClient.searchApiService.search().toString()
    }
}