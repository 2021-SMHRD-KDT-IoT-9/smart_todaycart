package com.example.todaycart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.PrintStreamPrinter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ShoppingActivity : AppCompatActivity() {
    lateinit var cost1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val rcv1 : RecyclerView = findViewById(R.id.rcv1)
        val rcv2 : RecyclerView = findViewById(R.id.rcv2)
        val btnAd : Button = findViewById(R.id.btnAd)
        val btnPayment : Button = findViewById(R.id.btnPayment)
        cost1 = findViewById(R.id.cost1)

        val products = ArrayList<ProductVO>()
        val ads = ArrayList<AdVO>()

        ads.add(AdVO(R.drawable.cida,"칠성사이다","1800"))
        ads.add(AdVO(R.drawable.beer,"테라","2000"))
        ads.add(AdVO(R.drawable.pepsi,"펩시제로","1800"))
        products.add(ProductVO(R.drawable.snack,"오!감자(오리지널)","2000"))

        val adapter = ProductAdapter(this ,R.layout.ad_list,products)
        rcv1.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rcv1.adapter = adapter

        btnAd.setOnClickListener {
            val adapter2 = AdAdapter(applicationContext,R.layout.ad_list2,ads)
            rcv2.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
            rcv2.adapter=adapter2
        }

    }
    fun changeCost(cost:Int){
        cost1.text = cost.toString()
    }


}