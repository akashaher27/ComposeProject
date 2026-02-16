package com.example.core.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<MovieRoomModel>)

    @Query("SELECT * FROM movie")
    fun getMovie(): Flow<List<MovieRoomModel>>

    @Delete
    suspend fun deleteMovie(movie: MovieRoomModel)
}
