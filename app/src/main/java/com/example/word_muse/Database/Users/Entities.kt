package com.example.word_muse.Database.Users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.word_muse.API.DictionaryDataItem

@Entity(tableName = "User")
data class User(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "password") val password: String?,
)

@Entity(tableName = "Favorite")
data class Favorite(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "word") val word: DictionaryDataItem
)