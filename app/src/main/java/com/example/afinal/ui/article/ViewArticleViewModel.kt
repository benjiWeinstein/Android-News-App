package com.example.afinal.ui.article

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
class ViewArticleViewModel @Inject constructor(private val articleRepository: ArticleRepository) : ViewModel()  {


    fun saveArticleAsFavorite(article: Article) = viewModelScope.launch {
        article.isFavorite = true
        articleRepository.upsert(article)
    }

}