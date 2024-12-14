package com.example.word_muse.Database.Favorites

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.word_muse.Database.Users.FavoriteDao

@Database(
    entities = [Favorite::class],
    version = 1
)
abstract class FavoriteDatabase: RoomDatabase() {
    abstract val dao: FavoriteDao
}