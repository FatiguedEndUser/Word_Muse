//XML/Face
//Call the fragment

package com.example.word_muse.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.word_muse.API.RetrofitClient

class HomeViewModel : ViewModel() {
    private val _wordData = MutableLiveData("No Data")
    val wordData: LiveData<String> get() = _wordData
}