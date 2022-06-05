package com.example.afinal.data.repository

import com.example.afinal.data.local_db.ArticleDao
import com.example.afinal.data.models.Article
import com.example.afinal.data.remote_db.ArticleRemoteDataSource
import com.example.afinal.utils.performFetchingAndSaving
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val remoteDataSource : ArticleRemoteDataSource,
    private val localDataSource : ArticleDao
){
//
//    fun getCities() = performFetchingAndSaving(
//        {localDataSource.getAllCities()},
//        {remoteDataSource.getCurrentWeather()},
//        {localDataSource.insertCities(List(it)}
//    )

    fun getBreakingNews(country : String, page: Int) = performFetchingAndSaving(
        {localDataSource.getAllArticles()},
        {remoteDataSource.getBreakingNews(country, page)},
        {localDataSource.insertArticles(it.articles)}
    )

    fun searchForNews(q : String, page: Int) = performFetchingAndSaving(
        {localDataSource.getSearchArticles(q)},
        {remoteDataSource.searchForNews(q, page)},
        {localDataSource.insertArticles(it.articles)}
    )

    suspend fun upsert(article: Article) = localDataSource.insertArticle(article)

    fun getSavedNews() = localDataSource.getAllFavorites()

    suspend fun deleteArticle(article: Article) = localDataSource.deleteArticle(article)
}