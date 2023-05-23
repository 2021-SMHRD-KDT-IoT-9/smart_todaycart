package com.example.todaycart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val rcv1 : RecyclerView = findViewById(R.id.rcv1)
        val rcv2 : RecyclerView = findViewById(R.id.rcv2)
        val btnAd : Button = findViewById(R.id.btnAd)
        val btnPayment : Button = findViewById(R.id.btnPayment)
        val cost1 : TextView = findViewById(R.id.cost1)

        var products : MutableList<ProductVO> = mutableListOf()
        products.add(ProductVO(R.drawable.snack,"오!감자(오리지널)","2000원"))
        val adapter = ProductAdapter(applicationContext,R.layout.shopping_list,products)
        rcv1.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        rcv1.adapter=adapter
        rcv2.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        rcv2.adapter=adapter


    }
}