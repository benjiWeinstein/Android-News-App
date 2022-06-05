package com.example.afinal.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afinal.data.models.Article
import com.example.afinal.data.repository.ArticleRepository
import com.example.afinal.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class searchViewModel @Inject constructor(val articleRepository: ArticleRepository) : ViewModel() {

    var showMessage = MutableLiveData<Boolean>()

    lateinit var articles :  LiveData<Resource<List<Article>>>
    fun searchNews(query: String)  {
        articles = articleRepository.searchForNews(query, 1)
//        articles.
    }



}
