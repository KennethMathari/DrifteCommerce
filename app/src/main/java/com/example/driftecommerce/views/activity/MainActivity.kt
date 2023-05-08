package com.example.driftecommerce.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.driftecommerce.R
import com.example.driftecommerce.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomnav.setOnItemSelectedListener{menuItem->
            val navHost = binding.navHostFragment.id
            when(menuItem.itemId){
                R.id.home -> {
                    findNavController(navHost).navigate(R.id.productListFragment)
                    true
                }
                R.id.cart -> {
                    findNavController(navHost).navigate(R.id.cartFragment)
                    true
                }
                else -> false
            }
        }

    }

}