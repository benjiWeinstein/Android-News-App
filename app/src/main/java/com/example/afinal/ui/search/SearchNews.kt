package com.example.afinal.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afinal.R
import com.example.afinal.databinding.FragmentSearchBinding
import com.example.afinal.databinding.FragmentSearchNewsBinding
import com.example.afinal.utils.Loading
import com.example.afinal.utils.Success
import com.example.afinal.utils.autoCleared

class SearchNews : Fragment() {

    private var binding : FragmentSearchNewsBinding by autoCleared()
    private lateinit var myQuery : String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchBtn.setOnClickListener{
            //validate input
            myQuery = binding.etSearch.text.toString()
            if (validateInput(myQuery)){
                val action = R.id.action_searchNews_to_search
                val myBundle = Bundle()
                myBundle.putString("query", myQuery)
                findNavController().navigate(action, myBundle)
            }


        }

    }

    private fun validateInput(input: String) : Boolean{
        return true
    }

}