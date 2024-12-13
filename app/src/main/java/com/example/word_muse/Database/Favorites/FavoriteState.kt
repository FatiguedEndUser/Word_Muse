package com.example.word_muse.Database.Favorites


data class FavoriteState(
    val favorites: List<Favorite> = emptyList(),
    val isAddingFavorite: Boolean = false,
)