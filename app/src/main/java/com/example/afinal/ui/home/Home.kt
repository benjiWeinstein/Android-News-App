package com.example.afinal.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.R
import com.example.afinal.data.models.Article
import com.example.afinal.data.models.Source
import com.example.afinal.databinding.FragmentHomeBinding
import com.example.afinal.utils.Loading
import com.example.afinal.utils.Success
import com.example.afinal.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Home : Fragment(), HomeAdapter.ArticleItemListener {
    private val viewModel : homeViewModel by viewModels()
    private var binding : FragmentHomeBinding by autoCleared()
    private  lateinit var  adapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter


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
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onArticleClick(characterId: Int) {
        TODO("Not yet implemented")
    }


}