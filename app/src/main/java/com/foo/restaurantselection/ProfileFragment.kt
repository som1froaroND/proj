package com.foo.restaurantselection

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileFragment : Fragment(), RecViewAdapter.AdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
//*
        // Recycler View
        val myFavRecycler_view = view.findViewById<RecyclerView>(R.id.recycler_view_fav)

        val exampleList = generateDummyList(2)

        myFavRecycler_view.adapter = RecViewAdapter(exampleList, this)
        //myFavRecycler_view.adapter = OnlinRestRecViewAdapter()
        myFavRecycler_view.layoutManager = LinearLayoutManager(context)
//        myFavRecycler_view.setHasFixedSize(true)
  //  */

        return view
    }

    private fun generateDummyList(size: Int): List<RecViewItem> {
        val list = ArrayList<RecViewItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            val item = RecViewItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }


    override fun onClick(rec_view_item: RecViewItem) {
        Log.d("Clicked ", rec_view_item.text1)

        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToDetailFragment(rec_view_item,null,null))
    }

    /*
    override fun onClick(rec_view_item: RecViewItem) {
        Log.d("Clicked ", rec_view_item.text1)

        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToDetailFragment(rec_view_item))
    }


    override fun onClick(rec_view_item: RecViewItemRest) {
        Log.d("Clicked ", rec_view_item.text1)

        findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToDetailFragment(
            RecViewItem(R.drawable.ic_android, rec_view_item.name, rec_view_item.address),
            rec_view_item,
            RecViewItemRest(R.drawable.ic_android,
                rec_view_item.name,
                rec_view_item.address,
                rec_view_item.city,
                rec_view_item.state,
                rec_view_item.area,
                rec_view_item.postal_code,
                rec_view_item.country,
                rec_view_item.phone ,
                rec_view_item.lat,
                rec_view_item.lng,
                rec_view_item.price,
                rec_view_item.reserve_url,
                rec_view_item.mobile_reserve_url)))
    }
    */
}