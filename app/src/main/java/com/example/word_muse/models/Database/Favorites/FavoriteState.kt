package com.example.word_muse.models.Database.Favorites

import com.example.word_muse.API.DictionaryDataItem

data class FavoriteState (
    val favorites: List<DictionaryDataItem>,
    val isAddingFavorite: Boolean = false,
)