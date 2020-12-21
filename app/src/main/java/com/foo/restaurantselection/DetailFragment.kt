package com.foo.restaurantselection

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        //Log.d("adat", args.adatAtadas.text1)
        //Log.d("adat", args.adatAtadas.name)
    if(args.adatAtadas != null){
        view.text_view_text1.text = args.adatAtadas!!.text1
        view.textViewAddress.text = args.adatAtadas!!.text2
    }


        if(args.adatAtadRestaurant != null){
            view.text_view_text1.text = args.adatAtadRestaurant!!.name
            view.textViewAddress.text = args.adatAtadRestaurant!!.address
        view.textViewArea.text =args.adatAtadRestaurant!!.area
        view.textViewAddress.text =args.adatAtadRestaurant!!.address
        view.textViewCity.text ="City:  ${args.adatAtadRestaurant!!.city}"
        view.textViewCountry.text =args.adatAtadRestaurant!!.country
        view.textViewPhone.text ="Tel.:  ${args.adatAtadRestaurant!!.phone}"
        //view.textViewPrice.text ="Price:  ${args.adatAtadRestaurant!!.price}"
            if  (args.adatAtadRestaurant!!.price == 1)
                view.textViewPrice.text ="Price:  $"
            if  (args.adatAtadRestaurant!!.price == 2)
                view.textViewPrice.text ="Price:  $$"
            if  (args.adatAtadRestaurant!!.price == 3)
                view.textViewPrice.text ="Price:  $$$"
            if  (args.adatAtadRestaurant!!.price == 4)
                view.textViewPrice.text ="Price:  $$$$"
        }


        return view
    }

}