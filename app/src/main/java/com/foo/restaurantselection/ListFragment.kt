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
import com.foo.restaurantselection.viewmodel.RestaurantsViewModel

class ListFragment : Fragment(), RecViewAdapter.AdapterListener {

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

        myrecycler_view.adapter = OnlinRestRecViewAdapter()//= RecViewAdapter(exampleList, this)
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
        })

        return view
    }


    private fun gotOnlineResList(size: Int): List<RecViewItem> {
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

        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToDetailFragment(
                rec_view_item
            )
        )
    }
}