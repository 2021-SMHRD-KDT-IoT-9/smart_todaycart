package com.example.todaycart

import ProductAdapter
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

import kr.co.bootpay.android.*;
import kr.co.bootpay.android.models.Payload


import kr.co.bootpay.android.Bootpay
import kr.co.bootpay.android.BootpayAnalytics
import kr.co.bootpay.android.events.BootpayEventListener
import kr.co.bootpay.android.models.BootExtra
import kr.co.bootpay.android.models.BootItem
import kr.co.bootpay.android.models.BootUser
import kr.co.bootpay.android.models.statistics.BootStatItem


class ShoppingActivity : AppCompatActivity() {
    private lateinit var cost1: TextView
    val URL = "http://119.200.31.135:9090/project/shopingcart"
    var products1 = ArrayList<ProductVO>()
    lateinit var rcv1 :RecyclerView
    lateinit var requestQueue : RequestQueue
    var id :String = "손동연"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        val id = "손동연"
        val quantity = 5
        val totalCost = 6000.0
//
//       val sharedPreferences = getSharedPreferences("myPreferences", Context.MODE_PRIVATE)
//       val id =  sharedPreferences.getString("id", "")
//        val quantity = sharedPreferences.getString("quantity","")
//       val totalCost = sharedPreferences.getString("totalCost","")
        rcv1 = findViewById(R.id.rcv1)
        val rcv2: RecyclerView = findViewById(R.id.rcv2)
        val btnAd: Button = findViewById(R.id.btnAd)
        val btnPayment: Button = findViewById(R.id.btnPayment)

        cost1 = findViewById(R.id.cost1)

        val ads = ArrayList<AdVO>()
       requestQueue = Volley.newRequestQueue(this)

        val requestBody = JSONObject()

        rcv1()

        btnPayment.setOnClickListener {

            val application_id = "646d69333049c8001ef8bea7"
            val extra = BootExtra()
                .setCardQuota("0,2,3")
            var price = ProductVO().p_price.toDouble()
            val pg: String = "이니시스" //pg사
            val method: String = "휴대폰"  //결제수단
            val user = BootUser().setPhone("010-1234-5678")
            val items: MutableList<BootItem> = ArrayList()
            val item1 = BootItem().setName(ProductVO().p_name)
                .setId(ProductVO().p_code.toString())
                .setQty(quantity)
                .setPrice(totalCost)
            val payload = Payload()
            payload.setApplicationId(application_id)
                .setOrderName("부트페이 결제테스트")
                .setPg(pg)
                .setOrderId("1234")
                .setOrderId("1234")
                .setPrice(price)
                .setUser(user)
                .setExtra(extra).items = items
            val map: MutableMap<String, Any> = HashMap()
            map["1"] = "abcdef"
            map["2"] = "abcdef55"
            map["3"] = 1234
            payload.metadata = map
            Bootpay.init(supportFragmentManager, applicationContext)
                .setPayload(payload)
//결제에 필요한 정보가 담긴 payload 객체를 설정
                // ---> 결제 과정에서 필요한 정보들을 전달
                .setEventListener(/* listener = */ object : BootpayEventListener {
                    //결제 이벤트를 처리하는 리스너를 설정
                    // BootpayEventListener을 구현한 익명 클래스를 생성하여 리스너를 구현
                    //onCancel, onError, onClose, onIssued, onConfirm, onDone 메서드를 오버라이딩하여
                    // 해당 이벤트가 발생했을 때의 동작을 정의

                    //결제가 취소되었을 때 호출되는 메서드
                    //data 매개변수는 취소에 관련된 데이터를 전달받음
                    override fun onCancel(data: String) {
                        Log.d("bootpay", "cancel: $data")
                    }

                    //결제 도중 에러가 발생했을 때 호출되는 메서드
                    //data 매개변수는 에러에 관련된 데이터를 전달받음
                    override fun onError(data: String) {
                        Log.d("bootpay", "error: $data")
                    }

                    override fun onClose() {
                        Log.d("bootpay", "close")
                    }

                    //결제 창이 닫혔을 때 호출되는 메서드
                    //data 매개변수는 관련 데이터를 전달받음
                    //여기서는 결제 창을 닫는 동작 후 Bootpay.removePaymentWindow()를 호출하여 결제 창을 제거
                    fun onClose(data: String) {
                        Log.d("bootpay","close:$data")
                        Bootpay.removePaymentWindow()
                    }

                    //결제가 발행되었을 때 호출되는 메서드
                    //data 매개변수는 발행에 관련된 데이터를 전달받음
                    override fun onIssued(data: String) {
                        Log.d("bootpay", "issued: $data")
                    }

                    //결제 확인이 필요할 때 호출되는 메서드
                    //data 매개변수는 관련 데이터를 전달받음
                    //여기서는 결제를 진행하려 할 때 true를 반환하고, 결제를 진행하지 않을 때 false를 반환하도록 설정
                    override fun onConfirm(data: String): Boolean {
                        Log.d("bootpay", "confirm: $data")
                        //                        Bootpay.transactionConfirm(data); //재고가 있어서 결제를 진행하려 할때 true (방법 1)
                        return true //재고가 있어서 결제를 진행하려 할때 true (방법 2)
                        //                        return false; //결제를 진행하지 않을때 false
                    }

                    // 결제가 완료되었을 때 호출되는 메서드
                    //data 매개변수는 완료에 관련된 데이터를 전달받음
                    override fun onDone(data: String) {
                        Log.d("done", data)
                        startActivity(intent)
                    }
                }).requestPayment() //결제 요청을 수행

            sendPaymentDataToServer(id.toString(), products1)
        }
    }
    fun changeCost(cost: Int) {
        cost1.text = cost.toString()
    }

    private fun getBootUser(): BootUser? {
        val userId = "123411aaaaaaaaaaaabd4ss121"
        val user = BootUser()
        user.id = userId
        user.area = "서울"
        user.gender = 1 // 1: 남자, 0: 여자
        user.email = "test1234@gmail.com"
        user.phone = "010-1234-4567"
        user.birth = "1988-06-10"
        user.username = "홍길동"
        return user
    }
    private fun sendPaymentDataToServer(id:String,data: ArrayList<ProductVO>) {
        val url = "http://119.200.31.135:9090/project/payProduct?member_id="+id
        val requestQueue = Volley.newRequestQueue(this)
        val jsonObject = JSONObject()
        jsonObject.put("id", data)
        Log.d("test0",jsonObject.toString())
        val requestBody = jsonObject.toString()

        val stringRequest = object : StringRequest(
            Method.POST,
            url,
            Response.Listener<String> { response ->
                // 서버 응답 처리
                try {
                    val jsonResponse = JSONObject(response)
                    val success = jsonResponse.getBoolean("success")
                    val message = jsonResponse.getString("message")

                    if (success) {
                        // 결제 완료 처리
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    } else {
                        // 결제 실패 처리
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
            }
        ) {
            override fun getBodyContentType(): String {
                return "application/json"
            }

            override fun getBody(): ByteArray {
                return requestBody.toByteArray()
            }
        }

        requestQueue.add(stringRequest)
    }

    fun rcv1(){
        products1 = ArrayList<ProductVO>()
        val jsonObjectRequest = StringRequest(
            Request.Method.POST,
            URL,
            { response ->
                val json = JSONObject(response)
                val no1 =  json.getInt("p_code")
                val no2 = json.getString("p_name")
                val no3 = json.getInt("p_price")
                val no4 = json.getString("p_loc")
                val no5 = json.getInt("p_weight")
                val no6 = json.getString("p_img")
                val v = ProductVO(
                    p_code = no1,
                    p_name = no2,
                    p_price = no3,
                    p_loc = no4,
                    p_weight = no5,
                    p_img = no6
                )
                products1.add(v)
                val adapter = ProductAdapter(this, R.layout.shopping_list, products1)
                rcv1.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                rcv1.adapter = adapter

//                    btnAd.setOnClickListener {
//                        val adapter2 = AdAdapter(this, R.layout.ad_list2, ads)
//                        rcv2.layoutManager =
//                            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//                        rcv2.adapter = adapter2
//                    }
            },
            { error ->
                error.printStackTrace()
            }
        )
        requestQueue.add(jsonObjectRequest)

    }


}
