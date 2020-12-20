package com.foo.restaurantselection.data

import com.foo.restaurantselection.api.RetrofitInstance.api
import com.foo.restaurantselection.model.Restaurants

class RestaurantRepository {

    suspend fun getRestaurantsSync(): Restaurants {
        return api.getRestaurants(null, null, null,null,null,null, 25,1)
    }

}