package com.example.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieRoomModel::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private const val DATABASE_NAME = "myDatabase"

        @Volatile
        private var instance: LocalDatabase? = null

        fun create(context: Context): LocalDatabase {
            if (instance == null) {
                return Room
                    .databaseBuilder(
                        context = context.applicationContext,
                        klass = LocalDatabase::class.java,
                        name = DATABASE_NAME
                    ).build()
            }
            return instance!!

        }

    }
}
