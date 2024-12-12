package com.example.word_muse.Database.Favorites

import com.example.word_muse.API.DictionaryDataItem

data class FavoriteState(
    val favorites: DictionaryDataItem = emptyList(),
    val isAddingFavorite: Boolean = false,
)