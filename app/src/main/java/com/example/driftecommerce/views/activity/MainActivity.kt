package com.example.driftecommerce.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.driftecommerce.R
import com.example.driftecommerce.databinding.ActivityMainBinding
import com.example.driftecommerce.viewmodel.BottomNavigationViewModel
import com.example.driftecommerce.views.fragments.CartFragment
import com.example.driftecommerce.views.fragments.ProductListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val bottomNavigationViewModel: BottomNavigationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottonnav.setOnItemSelectedListener{menuItem->
            bottomNavigationViewModel.setSelectedItemId(menuItem.itemId)
            true
        }

        bottomNavigationViewModel.selectedItemId.observe(this){itemId->
            when(itemId){
                R.id.home -> replaceFragment(ProductListFragment())
                R.id.cart -> replaceFragment(CartFragment())
            }
        }

    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(binding.navHostFragment.id,fragment)
            commit()
        }
    }

}