package com.example.afinal.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class City(
    @PrimaryKey
    val name: String,
    val coord: CoOrds,
    val main: Main,
    val weather: Weather,
    val clouds: Clouds,
    val wind: Wind
) {}

data class CoOrds(val lat: Int, val lon:Int){}