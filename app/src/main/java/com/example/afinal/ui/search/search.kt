package com.example.afinal.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.R
import com.example.afinal.data.models.Article
import com.example.afinal.databinding.FragmentHomeBinding
import com.example.afinal.databinding.FragmentSearchBinding
import com.example.afinal.ui.home.HomeAdapter
import com.example.afinal.ui.home.homeViewModel
import com.example.afinal.utils.Loading
import com.example.afinal.utils.Success
import com.example.afinal.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

@AndroidEntryPoint
class search : Fragment(), searchAdapter.ArticleItemListener {
    private val viewModel : searchViewModel by viewModels()
    private var binding : FragmentSearchBinding by autoCleared()
    private  lateinit var  adapter: searchAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = searchAdapter(this)
        binding.rvSearchNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSearchNews.adapter = adapter

        val query = arguments?.get("query").toString()


        viewModel.searchNews(query)

        viewModel.articles.observe(viewLifecycleOwner) {
            when(it.status) {
                is Loading -> {
                }
                is Success -> {
                    adapter.setArticles(it.status.data!!)
                }

                is Error -> {
                }
            }
        }

        binding.searchBtn.setOnClickListener{
            findNavController().navigate(R.id.action_search_to_searchNews)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onArticleClick(article: Article) {
        val bundle = Bundle().apply {
            putSerializable("article", article)
        }
        findNavController().navigate(R.id.action_search_to_viewArticle, bundle)
    }


}