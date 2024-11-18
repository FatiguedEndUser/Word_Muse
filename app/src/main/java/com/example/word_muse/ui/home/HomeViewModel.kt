// Repo/Helper functions/DB

package com.example.word_muse.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.word_muse.DictionaryAPI
import kotlinx.coroutines.launch
import java.io.IOException

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

    //var user: User = User("name", "pass", "email")
    //methods to translate json into models

    //Search Function
    private fun search(){

    }

    //GET SEARCH
    private fun getSearch(query: String){
        try {
            viewModelScope.launch {
                val listResult = DictionaryAPI.retrofitService.search(query)
                searchState = SearchState.Success(listResult)
            }
        }catch (e: IOException){
            SearchState.Error
        }
    }

}