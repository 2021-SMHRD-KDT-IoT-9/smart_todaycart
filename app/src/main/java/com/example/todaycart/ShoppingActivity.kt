package com.example.todaycart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
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
        var ads : MutableList<AdVO> = mutableListOf()

        products.add(ProductVO(R.drawable.snack,"오!감자(오리지널)","2000원"))
        ads.add(AdVO(R.drawable.pepsi,"펩시제로","1,800원"))
        ads.add(AdVO(R.drawable.cida,"칠성사이다","1,800원"))
        ads.add(AdVO(R.drawable.beer,"테라","2,000원"))

        btnAd.setOnClickListener {
            val adapter2 =  AdAdapter(applicationContext,R.layout.ad_list2,ads)
            rcv2.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
            rcv2.adapter=adapter2
        }
        val adapter1 = ProductAdapter(applicationContext,R.layout.shopping_list,products)
        rcv1.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        rcv1.adapter=adapter1

//        adapter1.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
//            override fun onItemClick(v: View, products: MutableList<ProductVO>, pos: Int) {
//            }
//        })

        val exam1 = adapter1.updateTotalCost()

        Log.d("테스트", exam1.toString())


    }
}