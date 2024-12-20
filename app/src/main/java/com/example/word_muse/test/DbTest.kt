package com.example.word_muse.test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.word_muse.Database.DatabaseHelper
import android.content.ContentValues
import android.provider.ContactsContract.Data
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseHelperTest {

    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var database: SQLiteDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        databaseHelper = DatabaseHelper(
            null,
            null
        )
        database = databaseHelper.writableDatabase
    }

    @After
    fun teardown() {
        database.close()
        databaseHelper.close()
    }

    @Test
    fun insertAndReadData() {
        val values = ContentValues().apply {
            put(DatabaseHelper.USERNAME_COL, "JohnDoe")
            put(DatabaseHelper.PASSWORD_COL, "Passowrd1234")
        }

        val rowId = database.insert(DatabaseHelper.USER_TABLE, null, values)
        Assert.assertNotEquals(-1, rowId)

        val cursor = database.query(
            DatabaseHelper.USER_TABLE,
            null,
            null,
            null,
            null,
            null,
            null
        )

        Assert.assertTrue(cursor.moveToFirst())
        Assert.assertEquals("JohnDoe", cursor.getString(cursor.getColumnIndexOrThrow("user")))
        Assert.assertEquals("password1234", cursor.getInt(cursor.getColumnIndexOrThrow("password")))
        cursor.close()
    }

    @Test
    fun assertDataExistsInFavoriteTable() {
        val values = ContentValues().apply {
            put(DatabaseHelper.WORD_COL, "example")
            }
        database.insert(DatabaseHelper.FAVORITE_TABLE, null, values)


        val cursor = database.query(
            DatabaseHelper.FAVORITE_TABLE,
            null,
            "${DatabaseHelper.WORD_COL} = ?",
            arrayOf("example"),
            null,
            null,
            null
        )

        // 3. Assert that the data exists in the favorite table
        Assert.assertTrue(cursor.moveToFirst())
        Assert.assertEquals("example", cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.WORD_COL)))
        cursor.close()
    }

    @Test
    fun deleteUser() {
        // 1. Insert a user to be deleted
        val values = ContentValues().apply {
            put(DatabaseHelper.USERNAME_COL, "testuser")
            put(DatabaseHelper.PASSWORD_COL, "testpassword")
        }
        database.insert(DatabaseHelper.USER_TABLE, null, values)

        // 2. Delete the user
        val rowsAffected = database.delete(
            DatabaseHelper.USER_TABLE,
            "${DatabaseHelper.USERNAME_COL} = ?",
            arrayOf("testuser")
        )

        // 3. Assert that one row was deleted
        Assert.assertEquals(1, rowsAffected)

        // 4. Verify that the user is no longer in the database
        val cursor = database.query(
            DatabaseHelper.USER_TABLE,
            null,
            "${DatabaseHelper.USERNAME_COL} = ?",
            arrayOf("testuser"),
            null,
            null,
            null
        )
        Assert.assertFalse(cursor.moveToFirst()) // Cursor should be empty
        cursor.close()
    }

    @Test
    fun deleteFavorite() {
        // 1. Insert a favorite to be deleted
        val values = ContentValues().apply {
            put(DatabaseHelper.WORD_COL, "example")
        }
        database.insert(DatabaseHelper.FAVORITE_TABLE, null, values)

        // 2. Delete the favorite
        val rowsAffected = database.delete(
            DatabaseHelper.FAVORITE_TABLE,
            "${DatabaseHelper.WORD_COL} = ?",
            arrayOf("example")
        )

        // 3. Assert that one row was deleted
        Assert.assertEquals(1, rowsAffected)

        // 4. Verify that the favorite is no longer in the database
        val cursor = database.query(
            DatabaseHelper.FAVORITE_TABLE,
            null,
            "${DatabaseHelper.WORD_COL} = ?",
            arrayOf("example"),
            null,
            null,
            null
        )
        Assert.assertFalse(cursor.moveToFirst()) // Cursor should be empty
        cursor.close()
    }
}