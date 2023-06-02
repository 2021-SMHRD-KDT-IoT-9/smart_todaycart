package com.example.todaycartapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kr.co.bootpay.android.models.Payload


import kr.co.bootpay.android.Bootpay
import kr.co.bootpay.android.events.BootpayEventListener
import kr.co.bootpay.android.models.BootExtra
import kr.co.bootpay.android.models.BootItem
import kr.co.bootpay.android.models.BootUser

class PayActivity : AppCompatActivity() {
    private val application_id = "646d69333049c8001ef8bea7" //production
    //부트페이에서 발급받은 애플리케이션 ID를 저장하는 변수

    //onCreate 메서드: 액티비티가 생성될 때 호출되는 메서드, setContentView를 통해 화면 레이아웃을 설정한다.
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPay : Button = findViewById(R.id.btnPay)

        btnPay.setOnClickListener {
            goRequest(it)

        }


    }
    //goRequest 메서드: 결제 요청을 처리하는 메서드, 버튼 클릭 등의 이벤트로 호출됩니다.
    fun goRequest(v: View?) {
        val intent : Intent = Intent(this, PaySuccessActivity::class.java)
    //BootUser() 객체 생성: 구매자 정보를 설정하는 BootUser 객체를 생성하고, 전화번호를 설정
        val user = BootUser().setPhone("010-3269-0046") // 구매자 정보

    //BootExtra 객체 생성: 추가 결제 옵션을 설정하기 위한 BootExtra 객체를 생성, 할부 개월 수를 설정
        val extra = BootExtra()
            .setCardQuota("0,2,3") // 일시불, 2개월, 3개월 할부 허용, 할부는 최대 12개월까지 사용됨
                                   // (5만원 이상 구매시 할부허용 범위)

    //결제 정보 설정: 결제에 필요한 정보들을 설정
    // price 변수에는 총 결제 금액을 설정
        var price = 1000.0    // 총 결제 금액

    //pg와 method 변수에는 결제 수단과 PG사를 설정
        val pg: String = "이니시스" //pg사
        val method: String = "휴대폰"  //결제수단

    //상품 정보 설정: BootItem 객체를 생성하여 상품의 정보를 설정하고 리스트에 추가
        val items: MutableList<BootItem> = ArrayList()  //MutableList 객체를 생성 : BootItem객체 담는 곳
                                                        //ArrayList() 생성자를 통해 빈 리스트를 생성

        //상품설정
        val item1 = BootItem().setName("마우's 스").setId("ITEM_CODE_MOUSE").setQty(1).setPrice(500.0)
        val item2 = BootItem().setName("키보드").setId("ITEM_KEYBOARD_MOUSE").setQty(1).setPrice(500.0)

        //리스트 추가
        items.add(item1)
        items.add(item2)

        //Payload 객체 생성: 결제에 필요한 정보를 담는 Payload 객체를 생성, 앞서 설정한 정보들을 해당 객체에 설정한다.
        // 또한, items를 통해 상품 정보 리스트를 설정합니다.
        val payload = Payload() //Payload 객체를 생성
        payload.setApplicationId(application_id) //Payload 객체의 applicationId 속성에 애플리케이션 ID를 설정
                                                 //application_id = "646d69333049c8001ef8bea7" -> 발급받은 ID
            .setOrderName("부트페이 결제테스트") //Payload 객체의 orderName 속성에 주문명("부트페이 결제테스트)을 설정
            .setPg(pg)                        //Payload 객체의 pg 속성에 PG사를 설정
                                              //val pg: String = "나이스페이"
            .setOrderId("1234")               //Payload 객체의 orderId 속성에 주문 ID("1234")를 설정
            .setMethod(method)                //Payload 객체의 method 속성에 결제 수단을 설정
                                              //val method: String = "카드"
            .setPrice(price)                  //Payload 객체의 price 속성에 총 결제 금액을 설정
                                              //var price = 1000.0
            .setUser(user)                    //Payload 객체의 user 속성에 구매자 정보를 설정
                                              //val user = BootUser().setPhone("010-1234-5678")
            .setExtra(extra).items = items    //Payload 객체의 extra 속성에 추가 결제 옵션을 설정
                                              //앞서 생성하고 추가한 상품 정보 리스트가 대입
                                              //val items: MutableList<BootItem> = ArrayList()

        val map: MutableMap<String, Any> = HashMap()  //MutableMap 객체를 생성하여 map 변수에 할당
                                                      //map : 메타데이터를 저장하는 데 사용
        //메타데이터 맵에 키-값 쌍을 추가
        // "1" 키에 "abcdef" 문자열, "2" 키에 "abcdef55" 문자열, "3" 키에 1234 정수값을 설정
        map["1"] = "abcdef"
        map["2"] = "abcdef55"
        map["3"] = 1234
        payload.metadata = map //Payload 객체의 metadata 속성에 메타데이터 맵을 설정
                               // ---> 추가적인 정보를 결제

        //Bootpay.init 메서드 호출: Bootpay 라이브러리를 초기화하고, 설정한 결제 정보와 이벤트 리스너를 전달한다.
        // 이벤트 리스너에서는 결제 진행 상황에 따라 콜백 메서드들이 호출됨.

        // Bootpay 라이브러리를 초기화
        //supportFragmentManager: 액티비티의 프래그먼트 매니저를 전달
        //applicationContext: 애플리케이션의 컨텍스트를 전달
        Bootpay.init(supportFragmentManager, applicationContext)
            .setPayload(payload)                //결제에 필요한 정보가 담긴 payload 객체를 설정
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
    }
}