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
     var searchArticles: MutableLiveData<Resource<List<Article>>> = MutableLiveData<Resource<List<Article>>>()
//
//    val searchArticles = articleRepository.searchForNews("apple",1)
    fun searchNews(searchQuery: String) =
        run { searchArticles =
            this.articleRepository.searchForNews(searchQuery,1) as MutableLiveData<Resource<List<Article>>>
        }

}
