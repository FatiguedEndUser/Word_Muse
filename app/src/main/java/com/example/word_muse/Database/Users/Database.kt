package com.example.word_muse.Database.Users

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [User::class, Favorite::class],
    version = 1
)
abstract class Database: RoomDatabase() {
    abstract fun userDao(): UserDao
}