package com.example.afinal.data.local_db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.afinal.data.models.City

@Dao
interface CityDao {

    @Query("SELECT * FROM cities")
    fun getAllCities() : LiveData<List<City>>

    @Query("SELECT * FROM cities WHERE name = :cityName")
    fun getCity(cityName : String) : LiveData<City>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(city: City)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(cities : List<City>)
}
