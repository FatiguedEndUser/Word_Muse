package com.example.word_muse.Database.Users

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.word_muse.API.DictionaryDataItem
import com.example.word_muse.Database.Users.Favorite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insertFavorite(favorite: Favorite)

    @Delete
    suspend fun deleteFavorite(favorite: DictionaryDataItem)

    @Query("SELECT * FROM favorite ORDER BY favoriteWord ASC")
    fun getFavoritesByAlpha(): Flow<List<Favorite>>
}