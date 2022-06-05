package com.example.afinal.ui.favorites

import android.util.Log
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

    fun deleteArticle(article: Article) = viewModelScope.launch {
        articleRepository.deleteArticle(article)
    }
}