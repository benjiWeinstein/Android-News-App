package com.example.afinal.ui.favorites

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.Article
import com.example.afinal.data.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class favoritesViewModel @Inject constructor(val articleRepository: ArticleRepository) : ViewModel() {


    val favorites = articleRepository.getSavedNews()

    var showMessage = MutableLiveData<Boolean>()


    fun deleteArticle(article: Article) = viewModelScope.launch {
        articleRepository.deleteArticle(article)
    }

    fun removeArticleAsFavorite(article: Article) = viewModelScope.launch {
        deleteArticle(article)
        article.isFavorite = false
        articleRepository.upsert(article)
    }
}