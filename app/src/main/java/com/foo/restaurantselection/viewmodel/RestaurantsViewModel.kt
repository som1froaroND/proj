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
    var page: Int =1

    init {
        repo = RestaurantRepository()
        viewModelScope.launch {
            restaurants.postValue(repo.getRestaurantsSync().restaurants)
        }
    }

    fun prevNumbersRests() {
        viewModelScope.launch {
            page-=1
            restaurants.postValue(repo.getRestaurantsSync(page).restaurants)
        }
    }

    fun nextNumbersRests() {
        viewModelScope.launch {
            page+=1
            restaurants.postValue(repo.getRestaurantsSync(page).restaurants)
        }
    }
}