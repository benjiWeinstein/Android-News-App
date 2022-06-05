package com.example.afinal.data.local_db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.afinal.data.models.Article


@Database(entities = [Article::class], version = 6, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao() : ArticleDao

    companion object {

        @Volatile
        private var instance : AppDatabase?  = null

        fun getDatabase(context: Context) : AppDatabase =
            instance ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"articles_db")
                    .fallbackToDestructiveMigration().build().also {
                        instance = it
                    }
            }
    }
}

