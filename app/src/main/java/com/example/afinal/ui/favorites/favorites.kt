package com.example.afinal.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.R
import com.example.afinal.data.models.Article
import com.example.afinal.databinding.FragmentFavoritesBinding
import com.example.afinal.databinding.FragmentHomeBinding
import com.example.afinal.ui.home.HomeAdapter
import com.example.afinal.ui.home.homeViewModel
import com.example.afinal.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class favorites : Fragment(), favoritesAdapter.ArticleItemListener {

    private val viewModel : favoritesViewModel by viewModels()
    private var binding : FragmentFavoritesBinding by autoCleared()
    private  lateinit var  adapter: favoritesAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = favoritesAdapter(this)
        binding.rvSavedNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSavedNews.adapter = adapter

        viewModel.favorites.observe(viewLifecycleOwner) {
            adapter.setArticles(it)
        }
    }

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentFavoritesBinding.inflate(inflater,container,false)
            return binding.root
    }

    override fun onArticleClick(article: Article) {
        val bundle = Bundle().apply {
            putSerializable("article", article)
            putBoolean("isFav", true)
        }
        findNavController().navigate(R.id.action_favorites_to_viewArticle, bundle)

    }


}