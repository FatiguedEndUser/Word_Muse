package com.example.word_muse.models.Database.Favorites

import com.example.word_muse.API.DictionaryDataItem

sealed interface FavoriteEvent {
    data object saveFavorite: FavoriteEvent
    data object showDialog: FavoriteEvent
    data object hidDialog: FavoriteEvent
    data class addFavorite(val word: DictionaryDataItem): FavoriteEvent
    data class deleteFavorite(val word: DictionaryDataItem): FavoriteEvent
}