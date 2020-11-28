package com.foo.restaurantselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.foo.restaurantselection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate layout
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        //  set up  BottomNavigation
        val navController = findNavController(R.id.myNavHostFragment)

        //val bottomNav = binding.bottomNavigationView
        val bottomNav = binding.bottomNavigationView
        bottomNav?.setupWithNavController(navController)

    }
}