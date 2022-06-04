package com.example.afinal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.afinal.R
import com.google.android.material.bottomnavigation.BottomNavigationView

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)

//        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val nav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val homeFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (homeFragment != null) {
            nav.setupWithNavController(homeFragment.findNavController())
        }

//        bottomNavigationView.setupWithNavController(NavHostFragment.findNavController(NavHostFragment))
    }
}