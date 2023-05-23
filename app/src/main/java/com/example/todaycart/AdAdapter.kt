package com.example.todaycart

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdAdapter(context: Context, layout : Int, ads : MutableList<ProductVO>): RecyclerView.Adapter<AdAdapter.ViewHolder>() {

    val context = context
    val layout = layout
    val ads = ads


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {

    }

}