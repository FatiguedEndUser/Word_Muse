package com.example.word_muse.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context, factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        //CREATE USER TABLE
        db?.execSQL(
            "CREATE TABLE " + USER_TABLE + " ("
                    + UID_COL + " INTEGER PRIMARY KEY, " +
                    USERNAME_COL + " TEXT," +
                    PASSWORD_COL + " TEXT" + ")"
        )

        //CREATE FAVORITE TABLE
        db?.execSQL(
            "CREATE TABLE " + FAVORITE_TABLE + " ("
                    + FID_COL + " INTEGER PRIMARY KEY, " +
                    WORD_COL + " TEXT,"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + USER_TABLE)
        db?.execSQL("DROP TABLE IF EXIST" + FAVORITE_TABLE)
    }

    //Adding to our database
    fun addUser(username: String, password: String){
        val values = ContentValues()

        //Inserting in k-v pair
        values.put(USERNAME_COL, username)
        values.put(PASSWORD_COL, password)

        //Writable variable of our database
        val db = this.writableDatabase

        //Inserting values into the database
        db.insert(USER_TABLE, null, values)

        //Closing database
        db.close()
    }

    fun addFavorite(word: String){
        val values = ContentValues()

        //Inserting in k-v pair
        values.put(WORD_COL, word)

        //Writable variable of our database
        val db = this.writableDatabase

        //Inserting values into the database
        db.insert(FAVORITE_TABLE, null, values)

        //Closing database
        db.close()
    }

    //Getting data from our database
    fun getUser(): Cursor?{
        //Creating readable form of our database
        val db = this.readableDatabase

        //Returning our values from the database
        return db.rawQuery("SELECT * FROM $USER_TABLE", null)
    }

    fun getFavorite(): Cursor?{
        //Creating readable form of our database
        val db = this.readableDatabase

        //Returning our values from the database
        return db.rawQuery("SELECT * FROM $FAVORITE_TABLE", null)
    }

    //LOCAL VARS
    companion object{
        private val DATABASE_NAME = "mydb"
        private val DATABASE_VERSION = 1

        //USER table
        val USER_TABLE = "User"
        val UID_COL = "id"
        val USERNAME_COL = "username"
        val PASSWORD_COL = "password"

        //FAVORITE table
        internal val FAVORITE_TABLE = "Favorite"
        val FID_COL = "id"
        val WORD_COL = "word"
    }
}