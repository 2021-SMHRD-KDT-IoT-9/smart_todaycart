package com.example.todaycartapplication

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        //청과야채 버튼
        val btnVege: Button = findViewById(R.id.btnV_1)
        val bntVege2: Button = findViewById(R.id.btnV_2)
        val btnVege3: Button = findViewById(R.id.btnV_3)
        val btnVege4: Button = findViewById(R.id.btnV_4)

        //신선상품 버튼
        val btnFresh: Button = findViewById(R.id.btnF_1)

        //계란 김치 버튼
        val btnEgg: Button = findViewById(R.id.btnF_2)

        //와인,주류,위스키 버튼
        val btnDrink: Button = findViewById(R.id.btnD_1)
        val btnDrink2: Button = findViewById(R.id.btnD_2)

        //생활용품버튼
        val btnSang: Button = findViewById(R.id.btnS_1_1)
        val btnSang2: Button = findViewById(R.id.btnS_1_2)
        val btnSang3: Button = findViewById(R.id.btnS_1_3)

        //과자버튼
        val btnCook: Button = findViewById(R.id.btnC_1)
        val btnCook2: Button = findViewById(R.id.btnC_2)
        val btnCook3: Button = findViewById(R.id.btnC_3)
        val btnCook4: Button = findViewById(R.id.btnC_4)
        val btnCook5: Button = findViewById(R.id.btnC_5)

        //음료버튼
        val btnJuice: Button = findViewById(R.id.btnJ)


        // 버튼기능

        data class SnackItem(
            val name: String,
            val price: Int,
            val location: String
        )

        //과자버튼기능
        btnCook.setOnClickListener {
            val items = arrayOf(
                SnackItem("콘칩", 2000, "과자1-1"),
                SnackItem("바나나킥", 1500, "과자1-1"),
                SnackItem("쿠크다스", 3000, "과자1-3"),
            )

            // 커스텀 어댑터 클래스 생성 (ArrayAdapter<String> 를 상속)
            class CustomListAdapter(context: Context, private val items: Array<SnackItem>) :
                ArrayAdapter<SnackItem>(context, 0, items) {
                //getView메서드 오버라이드
                // ---> 각 항목에 대한 뷰 구성
                @SuppressLint("SuspiciousIndentation")
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    var itemView = convertView
                    if (itemView == null) {
                        itemView = LayoutInflater.from(context)
                            .inflate(R.layout.product_list, parent, false)
                    }

                    // 항목에 대한 뷰 구성
                    val tvName: TextView? = itemView?.findViewById(R.id.tvName)
                    val tvPrice: TextView? = itemView?.findViewById(R.id.tvPrice)
                    val tvLoc: TextView? = itemView?.findViewById(R.id.tvLoc)
                    val imgProduct: ImageView? = itemView?.findViewById(R.id.imgProduct)

                    // 해당 항목의 SnackItem 가져오기
                    val snackItem: SnackItem = items[position]

                    // 항목에 대한 정보 설정
                    tvName?.text = snackItem.name
                    tvLoc?.text = snackItem.location
                    tvPrice?.text = snackItem.price.toString()

                        // 이미지 설정
                        when (snackItem.name) {
                            "콘칩" -> imgProduct?.setImageResource(R.drawable.conchips)
                            "오감자" -> imgProduct?.setImageResource(R.drawable.snack)
                            // 다른 항목에 대한 이미지 설정
                            // ...
                            else -> imgProduct?.setImageResource(R.drawable.noimg)
                        }


                        // 다른 항목에 대한 이미지 설정 작성

                    return itemView!!
                }
            } //커스텀 어댑터 끝

            // CustomListAdapter 객체를 생성
            // 생성자에는 context와 items 배열을 전달
            val adapter = CustomListAdapter(this, items)

            //AlertDialog.Builder를 생성
            AlertDialog.Builder(this).apply {
                setTitle("과자")

                //setAdapter메서드로 customadapter설정 --> 다이얼로그에 항목들이 표시
                // 두 번째 매개변수로는 항목을 클릭했을 때 실행될 동작을 정의하는 리스너
                setAdapter(adapter) { dialog, which ->
                    // 아이템 클릭 시 동작할 내용 작성
                    Log.d("MainActivity", "Selected item: ${items[which]}")
                    dialog.dismiss()
                }
                //"닫기" 버튼을 추가
                setPositiveButton("닫기", null)
                show()
            }
        }


        btnCook2.setOnClickListener {
            val items = arrayOf(
                SnackItem("콘칩", 2000, "과자1-1"),
                SnackItem("바나나킥", 1500, "과자1-1"),
                SnackItem("쿠크다스", 3000, "과자1-3"),
            )

            // 커스텀 어댑터 클래스 생성 (ArrayAdapter<String> 를 상속)
            class CustomListAdapter(context: Context, private val items: Array<SnackItem>) :
                ArrayAdapter<SnackItem>(context, 0, items) {
                //getView메서드 오버라이드
                // ---> 각 항목에 대한 뷰 구성
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    var itemView = convertView
                    if (itemView == null) {
                        itemView = LayoutInflater.from(context)
                            .inflate(R.layout.product_list, parent, false)
                    }

                    // 항목에 대한 뷰 구성
                    val tvName: TextView? = itemView?.findViewById(R.id.tvName)
                    val tvPrice: TextView? = itemView?.findViewById(R.id.tvPrice)
                    val tvLoc: TextView? = itemView?.findViewById(R.id.tvLoc)
                    val imgProduct: ImageView? = itemView?.findViewById(R.id.imgProduct)

                    // 해당 항목의 SnackItem 가져오기
                    val snackItem: SnackItem = items[position]

                    // 항목에 대한 정보 설정
                    tvName?.text = snackItem.name
                    tvLoc?.text = snackItem.location
                    tvPrice?.text = snackItem.price.toString()

                    // 이미지 설정
                    when (snackItem.name) {
                        "콘칩" -> imgProduct?.setImageResource(R.drawable.conchips)
                        "오감자" -> imgProduct?.setImageResource(R.drawable.snack)
                        // 다른 항목에 대한 이미지 설정
                        // ...
                        else -> imgProduct?.setImageResource(R.drawable.noimg)
                    }


                    // 다른 항목에 대한 이미지 설정 작성

                    return itemView!!
                }
            } //커스텀 어댑터 끝

            // CustomListAdapter 객체를 생성
            // 생성자에는 context와 items 배열을 전달
            val adapter = CustomListAdapter(this, items)

            //AlertDialog.Builder를 생성
            AlertDialog.Builder(this).apply {
                setTitle("과자")

                //setAdapter메서드로 customadapter설정 --> 다이얼로그에 항목들이 표시
                // 두 번째 매개변수로는 항목을 클릭했을 때 실행될 동작을 정의하는 리스너
                setAdapter(adapter) { dialog, which ->
                    // 아이템 클릭 시 동작할 내용 작성
                    Log.d("MainActivity", "Selected item: ${items[which]}")
                    dialog.dismiss()
                }
                //"닫기" 버튼을 추가
                setPositiveButton("닫기", null)
                show()
            }
        }

        btnCook3.setOnClickListener {
            val items = arrayOf(
                SnackItem("콘칩", 2000, "과자1-1"),
                SnackItem("바나나킥", 1500, "과자1-1"),
                SnackItem("쿠크다스", 3000, "과자1-3"),
            )

            // 커스텀 어댑터 클래스 생성 (ArrayAdapter<String> 를 상속)
            class CustomListAdapter(context: Context, private val items: Array<SnackItem>) :
                ArrayAdapter<SnackItem>(context, 0, items) {
                //getView메서드 오버라이드
                // ---> 각 항목에 대한 뷰 구성
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    var itemView = convertView
                    if (itemView == null) {
                        itemView = LayoutInflater.from(context)
                            .inflate(R.layout.product_list, parent, false)
                    }

                    // 항목에 대한 뷰 구성
                    val tvName: TextView? = itemView?.findViewById(R.id.tvName)
                    val tvPrice: TextView? = itemView?.findViewById(R.id.tvPrice)
                    val tvLoc: TextView? = itemView?.findViewById(R.id.tvLoc)
                    val imgProduct: ImageView? = itemView?.findViewById(R.id.imgProduct)

                    // 해당 항목의 SnackItem 가져오기
                    val snackItem: SnackItem = items[position]

                    // 항목에 대한 정보 설정
                    tvName?.text = snackItem.name
                    tvLoc?.text = snackItem.location
                    tvPrice?.text = snackItem.price.toString()

                    // 이미지 설정
                    when (snackItem.name) {
                        "콘칩" -> imgProduct?.setImageResource(R.drawable.conchips)
                        "오감자" -> imgProduct?.setImageResource(R.drawable.snack)
                        // 다른 항목에 대한 이미지 설정
                        // ...
                        else -> imgProduct?.setImageResource(R.drawable.noimg)
                    }


                    // 다른 항목에 대한 이미지 설정 작성

                    return itemView!!
                }
            } //커스텀 어댑터 끝

            // CustomListAdapter 객체를 생성
            // 생성자에는 context와 items 배열을 전달
            val adapter = CustomListAdapter(this, items)

            //AlertDialog.Builder를 생성
            AlertDialog.Builder(this).apply {
                setTitle("과자")

                //setAdapter메서드로 customadapter설정 --> 다이얼로그에 항목들이 표시
                // 두 번째 매개변수로는 항목을 클릭했을 때 실행될 동작을 정의하는 리스너
                setAdapter(adapter) { dialog, which ->
                    // 아이템 클릭 시 동작할 내용 작성
                    Log.d("MainActivity", "Selected item: ${items[which]}")
                    dialog.dismiss()
                }
                //"닫기" 버튼을 추가
                setPositiveButton("닫기", null)
                show()
            }
        }


        btnCook3.setOnClickListener {
            val items = arrayOf(
                SnackItem("콘칩", 2000, "과자1-1"),
                SnackItem("바나나킥", 1500, "과자1-1"),
                SnackItem("쿠크다스", 3000, "과자1-3"),
            )

            // 커스텀 어댑터 클래스 생성 (ArrayAdapter<String> 를 상속)
            class CustomListAdapter(context: Context, private val items: Array<SnackItem>) :
                ArrayAdapter<SnackItem>(context, 0, items) {
                //getView메서드 오버라이드
                // ---> 각 항목에 대한 뷰 구성
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    var itemView = convertView
                    if (itemView == null) {
                        itemView = LayoutInflater.from(context)
                            .inflate(R.layout.product_list, parent, false)
                    }

                    // 항목에 대한 뷰 구성
                    val tvName: TextView? = itemView?.findViewById(R.id.tvName)
                    val tvPrice: TextView? = itemView?.findViewById(R.id.tvPrice)
                    val tvLoc: TextView? = itemView?.findViewById(R.id.tvLoc)
                    val imgProduct: ImageView? = itemView?.findViewById(R.id.imgProduct)

                    // 해당 항목의 SnackItem 가져오기
                    val snackItem: SnackItem = items[position]

                    // 항목에 대한 정보 설정
                    tvName?.text = snackItem.name
                    tvLoc?.text = snackItem.location
                    tvPrice?.text = snackItem.price.toString()

                    // 이미지 설정
                    when (snackItem.name) {
                        "콘칩" -> imgProduct?.setImageResource(R.drawable.conchips)
                        "오감자" -> imgProduct?.setImageResource(R.drawable.snack)
                        // 다른 항목에 대한 이미지 설정
                        // ...
                        else -> imgProduct?.setImageResource(R.drawable.noimg)
                    }


                    // 다른 항목에 대한 이미지 설정 작성

                    return itemView!!
                }
            } //커스텀 어댑터 끝

            // CustomListAdapter 객체를 생성
            // 생성자에는 context와 items 배열을 전달
            val adapter = CustomListAdapter(this, items)

            //AlertDialog.Builder를 생성
            AlertDialog.Builder(this).apply {
                setTitle("과자")

                //setAdapter메서드로 customadapter설정 --> 다이얼로그에 항목들이 표시
                // 두 번째 매개변수로는 항목을 클릭했을 때 실행될 동작을 정의하는 리스너
                setAdapter(adapter) { dialog, which ->
                    // 아이템 클릭 시 동작할 내용 작성
                    Log.d("MainActivity", "Selected item: ${items[which]}")
                    dialog.dismiss()
                }
                //"닫기" 버튼을 추가
                setPositiveButton("닫기", null)
                show()
            }
        }

        btnCook4.setOnClickListener {
            val items = arrayOf(
                SnackItem("콘칩", 2000, "과자1-1"),
                SnackItem("바나나킥", 1500, "과자1-1"),
                SnackItem("쿠크다스", 3000, "과자1-3"),
            )

            // 커스텀 어댑터 클래스 생성 (ArrayAdapter<String> 를 상속)
            class CustomListAdapter(context: Context, private val items: Array<SnackItem>) :
                ArrayAdapter<SnackItem>(context, 0, items) {
                //getView메서드 오버라이드
                // ---> 각 항목에 대한 뷰 구성
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    var itemView = convertView
                    if (itemView == null) {
                        itemView = LayoutInflater.from(context)
                            .inflate(R.layout.product_list, parent, false)
                    }

                    // 항목에 대한 뷰 구성
                    val tvName: TextView? = itemView?.findViewById(R.id.tvName)
                    val tvPrice: TextView? = itemView?.findViewById(R.id.tvPrice)
                    val tvLoc: TextView? = itemView?.findViewById(R.id.tvLoc)
                    val imgProduct: ImageView? = itemView?.findViewById(R.id.imgProduct)

                    // 해당 항목의 SnackItem 가져오기
                    val snackItem: SnackItem = items[position]

                    // 항목에 대한 정보 설정
                    tvName?.text = snackItem.name
                    tvLoc?.text = snackItem.location
                    tvPrice?.text = snackItem.price.toString()

                    // 이미지 설정
                    when (snackItem.name) {
                        "콘칩" -> imgProduct?.setImageResource(R.drawable.conchips)
                        "오감자" -> imgProduct?.setImageResource(R.drawable.snack)
                        // 다른 항목에 대한 이미지 설정
                        // ...
                        else -> imgProduct?.setImageResource(R.drawable.noimg)
                    }


                    // 다른 항목에 대한 이미지 설정 작성

                    return itemView!!
                }
            } //커스텀 어댑터 끝

            // CustomListAdapter 객체를 생성
            // 생성자에는 context와 items 배열을 전달
            val adapter = CustomListAdapter(this, items)

            //AlertDialog.Builder를 생성
            AlertDialog.Builder(this).apply {
                setTitle("과자")

                //setAdapter메서드로 customadapter설정 --> 다이얼로그에 항목들이 표시
                // 두 번째 매개변수로는 항목을 클릭했을 때 실행될 동작을 정의하는 리스너
                setAdapter(adapter) { dialog, which ->
                    // 아이템 클릭 시 동작할 내용 작성
                    Log.d("MainActivity", "Selected item: ${items[which]}")
                    dialog.dismiss()
                }
                //"닫기" 버튼을 추가
                setPositiveButton("닫기", null)
                show()
            }
        }

        btnCook5.setOnClickListener {
            val items = arrayOf(
                SnackItem("콘칩", 2000, "과자1-1"),
                SnackItem("바나나킥", 1500, "과자1-1"),
                SnackItem("쿠크다스", 3000, "과자1-3"),
            )

            // 커스텀 어댑터 클래스 생성 (ArrayAdapter<String> 를 상속)
            class CustomListAdapter(context: Context, private val items: Array<SnackItem>) :
                ArrayAdapter<SnackItem>(context, 0, items) {
                //getView메서드 오버라이드
                // ---> 각 항목에 대한 뷰 구성
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    var itemView = convertView
                    if (itemView == null) {
                        itemView = LayoutInflater.from(context)
                            .inflate(R.layout.product_list, parent, false)
                    }

                    // 항목에 대한 뷰 구성
                    val tvName: TextView? = itemView?.findViewById(R.id.tvName)
                    val tvPrice: TextView? = itemView?.findViewById(R.id.tvPrice)
                    val tvLoc: TextView? = itemView?.findViewById(R.id.tvLoc)
                    val imgProduct: ImageView? = itemView?.findViewById(R.id.imgProduct)

                    // 해당 항목의 SnackItem 가져오기
                    val snackItem: SnackItem = items[position]

                    // 항목에 대한 정보 설정
                    tvName?.text = snackItem.name
                    tvLoc?.text = snackItem.location
                    tvPrice?.text = snackItem.price.toString()

                    // 이미지 설정
                    when (snackItem.name) {
                        "콘칩" -> imgProduct?.setImageResource(R.drawable.conchips)
                        "오감자" -> imgProduct?.setImageResource(R.drawable.snack)
                        // 다른 항목에 대한 이미지 설정
                        // ...
                        else -> imgProduct?.setImageResource(R.drawable.noimg)
                    }


                    // 다른 항목에 대한 이미지 설정 작성

                    return itemView!!
                }
            } //커스텀 어댑터 끝

            // CustomListAdapter 객체를 생성
            // 생성자에는 context와 items 배열을 전달
            val adapter = CustomListAdapter(this, items)

            //AlertDialog.Builder를 생성
            AlertDialog.Builder(this).apply {
                setTitle("과자")

                //setAdapter메서드로 customadapter설정 --> 다이얼로그에 항목들이 표시
                // 두 번째 매개변수로는 항목을 클릭했을 때 실행될 동작을 정의하는 리스너
                setAdapter(adapter) { dialog, which ->
                    // 아이템 클릭 시 동작할 내용 작성
                    Log.d("MainActivity", "Selected item: ${items[which]}")
                    dialog.dismiss()
                }
                //"닫기" 버튼을 추가
                setPositiveButton("닫기", null)
                show()
            }
        }












    }


}