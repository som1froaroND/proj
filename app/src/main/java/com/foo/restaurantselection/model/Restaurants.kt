package com.foo.restaurantselection.model

data class Restaurants(
    val total_entries : Int,
    val count: Int,
    val pageSize: Int,
    val restaurants: List<Restaurant>
)