package com.example.afinal.data.models

data class Day(
    val main: Main,
    val weather: Weather,
    val clouds: Clouds,
    val wind: Wind,
    val visibility: Int,
//    val dt_text: String
) {
}

data class Main(
  val temp: Float,
  val feelsLike: Float,
  val temp_min: Float,
  val temp_max: Float,
  val humidity: Float,
){}

data class Weather(
    val id: Int,
    val main: String,
    val description: String
){}

data class Clouds(
    val all: Int
){}

data class Wind(
  val speed: Int,
){}