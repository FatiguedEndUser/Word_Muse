package com.example.word_muse.Database.Favorites

import com.example.word_muse.API.DictionaryDataItem

sealed interface FavoriteEvent {
    data class addFavorite(val word: DictionaryDataItem): FavoriteEvent
    data class deleteFavorite(val word: DictionaryDataItem): FavoriteEvent
    //data object showDialog: FavoriteEvent
    //data object hidDialog: FavoriteEvent
}