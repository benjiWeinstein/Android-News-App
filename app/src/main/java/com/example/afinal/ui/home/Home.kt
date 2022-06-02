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
import com.example.afinal.databinding.FragmentHomeBinding
import com.example.afinal.utils.Loading
import com.example.afinal.utils.Success
import com.example.afinal.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class Home : Fragment() {
    private val viewModel : homeViewModel by viewModels()
//    lateinit var binding : FragmentHomeBinding
    private var binding : FragmentHomeBinding by autoCleared()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        viewModel.city.observe(viewLifecycleOwner) {
//            when(it.status) {
//                is Loading -> {}
//
//                is Success -> {
//                    Toast.makeText(requireContext(), it.status.data.toString(), Toast.LENGTH_SHORT).show()
//                }
//                is Error -> {
//
//                }
//            }
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.articles.observe(viewLifecycleOwner) {
            when(it.status) {
                is Loading -> {
                Toast.makeText(requireContext(),"loading",Toast.LENGTH_LONG).show()
                }
                is Success -> {
                    binding.textView.text = it.status.data.toString()
                    Toast.makeText(requireContext(), "succes " +it.status.data.toString(), Toast.LENGTH_SHORT).show()
                }

                is Error -> {
                    Log.d("when", it.status.message.toString())
                    Toast.makeText(requireContext(),"error",Toast.LENGTH_LONG).show()
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


}