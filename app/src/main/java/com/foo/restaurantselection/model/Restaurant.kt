package com.foo.restaurantselection.model

import java.io.Serializable


data class Restaurant (

    val id : Int,
    val name : String,
    val address : String,
    val city : String,
    val state : String,
    val area : String,
    val postal_code :Int,
    val country : String,
    val phone : String,
    val lat : String,
    val lng : String,
    val price : Int,
    val reserve_url : String,
    val mobile_reserve_url : String,
    val image_url : String,

    ): Serializable