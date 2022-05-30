package com.example.afinal.data.repository

import com.example.afinal.data.local_db.CityDao
import com.example.afinal.data.remote_db.CityRemoteDataSource
import com.example.afinal.utils.performFetchingAndSaving
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CityRepository @Inject constructor(
    private val remoteDataSource : CityRemoteDataSource,
    private val localDataSource : CityDao
){

//    fun getCities() = performFetchingAndSaving(
//        {localDataSource.getAllCities()},
//        {remoteDataSource.getCurrentWeather()},
//        {localDataSource.insertCities(it.results)}
//    )

    fun getCity(cityName : String) = performFetchingAndSaving(
        {localDataSource.getCity(cityName)},
        {remoteDataSource.getCurrentWeather()},
        {localDataSource.insertCity(it)}
    )
}