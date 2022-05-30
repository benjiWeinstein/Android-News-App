package com.example.afinal.data.local_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.afinal.data.models.City


@Database(entities = [City::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cityDao() : CityDao

    companion object {

        @Volatile
        private var instance : AppDatabase?  = null

        fun getDatabase(context: Context) : AppDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"cities")
                    .fallbackToDestructiveMigration().build().also {
                        instance = it
                    }
            }
    }
}

