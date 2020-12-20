package com.foo.restaurantselection

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.foo.restaurantselection.model.Restaurant
import com.foo.restaurantselection.viewmodel.RestaurantsViewModel

class ListFragment : Fragment(), OnlinRestRecViewAdapter.AdapterListener {

    lateinit var mViewModel: RestaurantsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        mViewModel = ViewModelProvider(this).get(RestaurantsViewModel::class.java)

        // Recycler View
        val myrecycler_view = view.findViewById<RecyclerView>(R.id.recycler_view)

        myrecycler_view.adapter = OnlinRestRecViewAdapter(this)//= RecViewAdapter(exampleList, this)
        myrecycler_view.layoutManager = LinearLayoutManager(context)

/*
        val exampleList = generateDummyList(9)

        myrecycler_view.adapter = RecViewAdapter(exampleList, this)
        myrecycler_view.layoutManager = LinearLayoutManager(context)
        myrecycler_view.setHasFixedSize(true)

*/
        mViewModel.restaurants.observe(viewLifecycleOwner, {restaurants ->
            Log.d("Resp", restaurants.map{it.name}.toString())
            (myrecycler_view.adapter as OnlinRestRecViewAdapter).setData(restaurants)
            gotOnlineResList(restaurants, restaurants.size)
        })

        return view
    }


    private fun gotOnlineResList(rest: List<Restaurant>, size: Int): List<RecViewItem> {
        val list = ArrayList<RecViewItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_audio
                else -> R.drawable.ic_sun
            }
            //val item = RecViewItem(drawable, "Item $i", "Line 2")
            val item = RecViewItem(drawable, rest[i].name, rest[i].address)
            list += item
        }
        return list
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


    override fun onClick(rec_view_item: Restaurant) {

        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToDetailFragment(
                RecViewItem(R.drawable.ic_android, rec_view_item.name, rec_view_item.address)
            )
        )
    }
}