package com.example.afinal.ui.home
import androidx.lifecycle.ViewModel
import com.example.afinal.data.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class homeViewModel  @Inject constructor(articleRepository: ArticleRepository) : ViewModel(){

    val articles = articleRepository.getBreakingNews("us",1)

}