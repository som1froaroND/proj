package com.foo.restaurantselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rec_view_item.view.*

class RecViewAdapter(private val exampleList: List<RecViewItem>, val listener: AdapterListener) :
    RecyclerView.Adapter<RecViewAdapter.RecViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rec_view_item,
            parent, false)
        return RecViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        //holder.imageView2.setImageResource(currentItem.imageResource)
    }

    override fun getItemCount() = exampleList.size

    inner class RecViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
        val imageView2: ImageView = itemView.image_view_fav

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            listener.onClick(exampleList[adapterPosition])
        }
    }

    interface AdapterListener{
        fun onClick(rec_view_item : RecViewItem)
    }

}