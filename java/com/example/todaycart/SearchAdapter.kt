package com.example.todaycart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

// on below line we are creating a course rv adapter class.
class SearchAdapter(
    // on below line we are passing variables as course list and context
    private var searchList: ArrayList<ProductVO>,
) : RecyclerView.Adapter<SearchAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.CourseViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.search_list,
            parent, false
        )

        // at last we are returning our view holder
        // class with our item View File.
        return CourseViewHolder(itemView)
    }

    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<ProductVO>) {
        // below line is to add our filtered
        // list in our course array list.
        searchList = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: SearchAdapter.CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.tvName.text = searchList.get(position).p_name
        Glide.with(holder.itemView)
            .load("http://119.200.31.135:9090/project/productUpload/${searchList.get(position).p_img}")
            .into(holder.imgProduct)
        holder.tvLoc.text = searchList.get(position).p_loc
        holder.tvPrice.text = searchList.get(position).p_price.toString()
    }

    override fun getItemCount(): Int {
        // on below line we are returning
        // our size of our list
        return searchList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val imgProduct: ImageView = itemView.findViewById(R.id.imgProduct)
        val tvLoc : TextView = itemView.findViewById(R.id.tvLoc)
        val tvPrice : TextView = itemView.findViewById(R.id.tvPrice)
    }
}