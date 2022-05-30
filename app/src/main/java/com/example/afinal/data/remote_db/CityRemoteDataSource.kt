package com.example.afinal.data.remote_db

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CityRemoteDataSource @Inject constructor(
    private val weatherService: WeatherService) : BaseDataSource() {

    suspend fun getCurrentWeather() = getResult { weatherService.getCurrentWeather() }
}