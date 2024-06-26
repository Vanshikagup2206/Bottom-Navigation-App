package com.vanshika.bottomnavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
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
                R.id.moveToFirst-> navController?.navigate(R.id.firstFragment)
                R.id.moveToSecond-> navController?.navigate(R.id.secondFragment)
                R.id.moveToThird-> navController?.navigate(R.id.thirdFragment)
            }
            return@setOnItemSelectedListener true
        }
        navController?.addOnDestinationChangedListener{navController,destination, arguments->
            when(destination.id){
                R.id.firstFragment-> {
                    supportActionBar?.title = resources.getString(R.string.first_fragment)
                    binding?.bottomNav?.menu?.findItem(R.id.moveToFirst)?.isChecked = true
                }
                R.id.secondFragment-> {
                    supportActionBar?.title = resources.getString(R.string.second_fragment)
                    binding?.bottomNav?.menu?.findItem(R.id.moveToSecond)?.isChecked = true
                }
                R.id.thirdFragment-> {
                    supportActionBar?.title = resources.getString(R.string.third_fragment)
                    binding?.bottomNav?.menu?.findItem(R.id.moveToThird)?.isChecked = true
                }
            }
        }
    }
}