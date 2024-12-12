package com.example.word_muse.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.word_muse.Database.Favorites.FavoriteDao
import com.example.word_muse.Database.Favorites.FavoriteEvent
import com.example.word_muse.Database.Favorites.FavoriteState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoriteViewModel(private val dao: FavoriteDao): ViewModel() {
    private val _state = MutableStateFlow(FavoriteState())

    fun onEvent(event: FavoriteEvent){
        when(event){
            is FavoriteEvent.addFavorite -> {
                _state.update { it.copy(
                    favorites = event.word
                ) }
            }

            is FavoriteEvent.deleteFavorite -> {
                viewModelScope.launch {
                    dao.deleteFavorite(event.word)
                }
            }
        }
    }

}