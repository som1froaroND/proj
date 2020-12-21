package com.foo.restaurantselection.data

import com.foo.restaurantselection.api.RetrofitInstance.api
import com.foo.restaurantselection.model.Restaurants

class RestaurantRepository {

    suspend fun getRestaurantsSync(page: Int = 1): Restaurants {
        return api.getRestaurants(null, null, null,null,null,null, 25,page)
    }

}