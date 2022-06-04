package com.example.afinal.ui.home
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.models.Article
import com.example.afinal.data.repository.ArticleRepository
import com.example.afinal.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class homeViewModel  @Inject constructor(articleRepository: ArticleRepository) : ViewModel(){

    val articles = articleRepository.getBreakingNews("us",1)






}