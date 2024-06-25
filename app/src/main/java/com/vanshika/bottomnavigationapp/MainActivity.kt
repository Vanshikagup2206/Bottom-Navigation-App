package com.vanshika.bottomnavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.vanshika.bottomnavigationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding : ActivityMainBinding ?= null
    var navController : NavController ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        navController = findNavController(R.id.host)
        binding?.bottomNav?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.firstFragment-> navController?.navigate(R.id.firstFragment)
                R.id.secondFragment-> navController?.navigate(R.id.secondFragment)
                R.id.thirdFragment-> navController?.navigate(R.id.thirdFragment)
            }
            return@setOnItemSelectedListener true
        }
    }
}