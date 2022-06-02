package com.example.afinal.data.remote_db

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRemoteDataSource @Inject constructor(
    private val newsService: NewsService) : BaseDataSource() {

    suspend fun getBreakingNews(country : String, page: Int) = getResult { newsService.getBreakingNews(country,page) }

    suspend fun searchForNews(q : String, page: Int) = getResult { newsService.searchForNews(q,page) }
}