package com.example.word_muse.Database

import android.database.sqlite.SQLiteDatabase

class DatabaseHelper {
    companion object{
        const val DATABASE_NAME = "Database.db"
        const val DATABASE_VERSION = 1
    }

    fun onCreate(db: SQLiteDatabase){
        //Create table and queries
        db.execSQL(
            "CREATE TABLE USERS (_id INTEGER PRIMARY KEY, username TEXT, password TEXT)"
        )
        db.execSQL(
            "CREATE TABLE FAVORITE (_id INTEGER PRIMARY KEY, word TEXT)"
        )
    }

    fun onUpgrade(db: SQLiteDatabase){
        //Migration code
    }
}