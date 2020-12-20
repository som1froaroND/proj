package com.foo.restaurantselection.api

import com.foo.restaurantselection.model.Restaurants
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenTableApi {

    @GET("restaurants")
    suspend fun getRestaurants(
        @Query("country") country: String?,
        @Query("state") state: String?,
        @Query("city") city: String?,
        @Query("zip") zip: String?,
        @Query("address") address: String?,
        @Query("name") name: String?,
        @Query("per_page") perPage: Int?,
        @Query("page") page: Int?,
    ): Restaurants

}