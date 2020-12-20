package com.foo.restaurantselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.foo.restaurantselection.model.Restaurant
import com.foo.restaurantselection.utils.load
import kotlinx.android.synthetic.main.rec_view_item.view.*

class OnlinRestRecViewAdapter : RecyclerView.Adapter<OnlinRestRecViewAdapter.ShowData>() {

    private var restData: List<Restaurant> = listOf()

    inner class ShowData(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowData {
        return ShowData(
            LayoutInflater.from(parent.context).inflate(R.layout.rec_view_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ShowData, position: Int) {
       // holder.itemView.image_view.load(if (position % 2 == 0) R.drawable.ic_android else restData[position].image_url)
        holder.itemView.image_view.load(if (position % 2 == 0) "" else restData[position].image_url)
        holder.itemView.text_view_1.text =
            if (30 < restData[position].name.length) restData[position].name.substring(0..25) else restData[position].name
        holder.itemView.text_view_2.text = restData[position].address
    }

    override fun getItemCount(): Int {
        return restData.size
    }

    fun setData(data: List<Restaurant>) {
        restData = data
        notifyDataSetChanged()
    }

}