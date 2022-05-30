package com.example.afinal.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Forecast(
    val list: List<Day>,
    val city: City
) {}