// Repo/Helper functions/DB

package com.example.word_muse.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.word_muse.models.User

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    //var user: User = User("name", "pass", "email")
    //api calls for searching
    //get calls for words
    //methods to translate json into models

}