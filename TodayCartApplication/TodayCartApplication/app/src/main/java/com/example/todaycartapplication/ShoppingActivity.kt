package com.example.todaycartapplication

import ProductAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import okhttp3.OkHttpClient
//import okhttp3.Request
//import okhttp3.Response
//import okhttp3.WebSocket
//import okhttp3.WebSocketListener
import org.json.JSONObject

class ShoppingActivity : AppCompatActivity() {
      lateinit var cost1 : TextView
//    lateinit var client: OkHttpClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
//        client = OkHttpClient()
        val URL = "ws://119.200.31.135:9090/project/shopingcart"
        val rcv1 : RecyclerView = findViewById(R.id.rcv1)
        val rcv2 : RecyclerView = findViewById(R.id.rcv2)
        val btnAd : Button = findViewById(R.id.btnAd)
        val btnPayment : Button = findViewById(R.id.btnPayment)
        val btnRes : Button = findViewById(R.id.btnRes)
        cost1 = findViewById(R.id.cost1)

        val products = ArrayList<ProductVO>()
        val ads = ArrayList<AdVO>()
//        val request: Request = Request.Builder()
//            .url("ws://119.200.31.135:9090/project/shopingcart")
//            .build()
//        val listener = object : WebSocketListener(){

//            override fun onOpen(webSocket: WebSocket, response: Response) {
//                super.onOpen(webSocket, response)
//                Log.d("Socket","생성")
//            }
//            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
//                // 연결이 완전히 종료된 후에 호출됩니다.
//                Log.d("Socket","종료")
//            }
//
//            override fun onMessage(webSocket: WebSocket, text: String) {
//                // 웹소켓으로부터 문자열 메시지를 받음
//                Log.d("test",text)
//                val json1 = JSONObject(text)
//
//                val no1 = json1.getString("p_code")
//                val no2 = json1.getString("p_name")
//                val no3 = json1.getString("p_price")
//                val no4 = json1.getString("p_loc")
//                val no5 = json1.getString("p_weight")
//                Log.d("test3",no1+no2+no3+no4+no5)
//            }
//        }
//        val websocket = client.newWebSocket(request, listener)
//        btnRes.setOnClickListener {
//            websocket.close(1000, "Goodbye, WebSocket!")
//        }


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