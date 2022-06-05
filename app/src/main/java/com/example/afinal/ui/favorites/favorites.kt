package com.example.afinal.ui.favorites

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.R
import com.example.afinal.data.models.Article
import com.example.afinal.databinding.FragmentFavoritesBinding
import com.example.afinal.databinding.FragmentHomeBinding
import com.example.afinal.ui.home.HomeAdapter
import com.example.afinal.ui.home.homeViewModel
import com.example.afinal.utils.autoCleared
import com.google.android.material.snackbar.Snackbar
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
            viewModel.showMessage.value = adapter.itemCount <= 0
        }


        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = adapter.getArticle(position)
                adapter.removeArticle(position)
                viewModel.removeArticleAsFavorite(article)

                viewModel.showMessage.value = adapter.itemCount <= 0

                }

        }


        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rvSavedNews)
        }

        viewModel.showMessage.observe(viewLifecycleOwner){
        if (it) {
            binding.noFavtxt.visibility = View.VISIBLE
        } else{
            binding.noFavtxt.visibility = View.INVISIBLE

        }
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