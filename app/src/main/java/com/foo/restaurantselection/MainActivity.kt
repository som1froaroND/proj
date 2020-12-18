package com.foo.restaurantselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.foo.restaurantselection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

       // setContentView(R.layout.activity_main)


        setTheme(R.style.Theme_RestaurantSelection)



        // inflate layout
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        setContentView(binding.root)

        //  set up  BottomNavigation
        val navController = findNavController(R.id.myNavHostFragment)

        //val bottomNav = binding.bottomNavigationView
        val bottomNav = binding.bottomNavigationView
        bottomNav?.setupWithNavController(navController)

        //bottomNav.visibility = View.GONE  //needed to tteet recicleView


    }

}