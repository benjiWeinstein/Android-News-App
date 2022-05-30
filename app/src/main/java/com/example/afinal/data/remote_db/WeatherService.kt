package com.example.afinal.data.remote_db

import com.example.afinal.data.models.City
import retrofit2.Response
import retrofit2.http.GET


interface WeatherService {

    @GET("lat=27.2046&lon=27.2046&appid=2ac9ac4504678eb4846e2a449116396d")
    suspend fun getCurrentWeather() : Response<City>

}