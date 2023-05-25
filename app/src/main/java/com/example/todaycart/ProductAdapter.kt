package com.example.todaycart

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(context: Context, layout : Int,products : MutableList<ProductVO>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    val context = context
    val products = products
    val layout  = layout


    var currentQuantity: Int = 1
    var newQuantity: Int = 0
    val inflater = LayoutInflater.from(context)

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val productName : TextView = view.findViewById(R.id.productName) // 제품 이름
        val cost : TextView = view.findViewById(R.id.cost) // 제품 가격
        val quantity : TextView = view.findViewById(R.id.quantity) // 제품 갯수
        val img2 : ImageView = view.findViewById(R.id.img2) // 제품 사진
        val btnPlus : Button = view.findViewById(R.id.btnPlus)
        val btnMinus : Button = view.findViewById(R.id.btnMinus)
        val btnDelete : ImageView = view.findViewById(R.id.btnDelete)
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
        holder.btnDelete.setImageResource(R.drawable.baseline_delete_24)
        holder.btnPlus.setOnClickListener {
            currentQuantity = holder.quantity.text.toString().toInt()
            newQuantity = currentQuantity + 1
            holder.quantity.text = newQuantity.toString()
            Log.d("TEST1",newQuantity.toString())
        }
        holder.btnMinus.setOnClickListener {
            currentQuantity = holder.quantity.text.toString().toInt()
            if (currentQuantity > 0) {
            newQuantity = currentQuantity - 1
            holder.quantity.text = newQuantity.toString()
            Log.d("TEST2", newQuantity.toString())
            }else {
                Toast.makeText(context,"message",Toast.LENGTH_SHORT).show()
            }

            val shoppingActivity = context as ShoppingActivity
            var amount = holder.quantity.text.toString().toInt()
            Log.d("TEST3",amount.toString())
            val price = holder.cost.text.toString().toInt()
            Log.d("TEST4",price.toString())
            shoppingActivity.changeCost(price * amount)

        }
          }


}

