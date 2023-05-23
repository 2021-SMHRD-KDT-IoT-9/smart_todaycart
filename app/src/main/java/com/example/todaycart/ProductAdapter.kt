package com.example.todaycart

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(context: Context, layout : Int, products : MutableList<ProductVO>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    val context = context
    val layout = layout
    val products = products
    val inflater = LayoutInflater.from(context)

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val productName : TextView = view.findViewById(R.id.productName)
        val cost : TextView = view.findViewById(R.id.cost)
        var quantity : TextView = view.findViewById(R.id.quantity)
        val img2 : ImageView = view.findViewById(R.id.img2)
        val btnPlus : Button = view.findViewById(R.id.btnPlus)
        val btnMinus : Button = view.findViewById(R.id.btnMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.shopping_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cost.text = products[position].cost
        holder.productName.text = products[position].name
        holder.img2.setImageResource(products[position].img2)
        holder.btnPlus.setOnClickListener {
            holder.quantity.text = products[position].cost
        }
        holder.btnMinus.setOnClickListener {
            holder.quantity.text = products[position].cost
        }
    }
}