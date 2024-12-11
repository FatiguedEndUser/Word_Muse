package com.example.word_muse.models.Database.Favorites
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.word_muse.API.DictionaryDataItem

@Entity
data class Favorite(
    val favoriteWord: DictionaryDataItem,
    @PrimaryKey(autoGenerate = true)
    val id: Int
)