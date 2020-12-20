package com.foo.restaurantselection.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foo.restaurantselection.data.RestaurantRepository
import com.foo.restaurantselection.model.Restaurant
import kotlinx.coroutines.launch

class RestaurantsViewModel : ViewModel() {
    private val repo: RestaurantRepository
    val restaurants: MutableLiveData<List<Restaurant>> = MutableLiveData()

    init {
        repo = RestaurantRepository()
        viewModelScope.launch {
            restaurants.postValue(repo.getRestaurantsSync().restaurants)
        }
    }
}