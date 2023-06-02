package com.example.todaycartapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MapActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map2)

        //과자버튼
        val btnCook : Button = findViewById(R.id.btnC_1)
        val btnCook2 : Button = findViewById(R.id.btnC_2)
        val btnCook3 : Button = findViewById(R.id.btnC_3)
        val btnCook4 : Button = findViewById(R.id.btnC_4)
        val btnCook5 : Button = findViewById(R.id.btnC_5)

        //생활용품버튼
        val btnSang : Button = findViewById(R.id.btnS_1_1)
        val btnSang2 : Button = findViewById(R.id.btnS_1_2)
        val btnSang3 : Button = findViewById(R.id.btnS_1_3)

        //와인,주류,위스키 버튼
        val btnDrink : Button = findViewById(R.id.btnD_1)
        val btnDrink2 : Button = findViewById(R.id.btnD_2)

        //음료버튼
        val btnJuice : Button =  findViewById(R.id.btnJ)

        //위치정보가져오기
        val location = intent.getStringExtra("location")

        //버튼색상변경

        when (location) {
            "주류 1-2" -> btnDrink.setBackgroundColor(Color.rgb(180, 156, 246))
            "음료 1-3" -> btnJuice.setBackgroundColor(Color.rgb(255,162,239))
            "스낵류 2-2" -> btnCook3.setBackgroundColor(Color.rgb(255,162,239))
        }

    }
    }
