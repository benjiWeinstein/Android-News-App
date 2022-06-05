package com.example.afinal.ui.article

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.afinal.R
import com.example.afinal.data.models.Article
import com.example.afinal.databinding.FragmentHomeBinding
import com.example.afinal.databinding.FragmentViewArticleBinding
import com.example.afinal.ui.home.homeViewModel
import com.example.afinal.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewArticle : Fragment() {
    private var binding : FragmentViewArticleBinding by autoCleared()
    private val viewModel : ViewArticleViewModel by viewModels()
    lateinit var article: Article
    var isFav: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        article = arguments?.getSerializable("article") as Article
        Log.d("sh0",article.toString())
        isFav = arguments?.getBoolean("isFav") as Boolean


        if (isFav) {
            binding.fav.visibility = View.INVISIBLE
        }

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url!!)

        }

        binding.fav.setOnClickListener{
            viewModel.saveArticleAsFavorite(article)
            Toast.makeText(requireContext(), "Saved to Favorites", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewArticleBinding.inflate(inflater,container,false)
        return binding.root
    }

}