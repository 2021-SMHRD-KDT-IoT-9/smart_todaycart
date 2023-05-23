package com.example.todaycart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Main_AfterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_after)
        val tvLogin : TextView = findViewById(R.id.tvLogin)
        val btnBucket : Button = findViewById(R.id.btnBucket)
        val btnSearch : Button = findViewById(R.id.btnSearch)
        val btnMap : Button = findViewById(R.id.btnMap)
        val btnCall : Button = findViewById(R.id.btnCall)

        var id = intent.getStringExtra("id")
        var pw = intent.getStringExtra("pw")
        if (id.equals("손동연")&&pw.equals("1234")){
            Toast.makeText(this,"로그인 성공", Toast.LENGTH_SHORT).show()
            tvLogin.text = "${id}님 환영합니다 \n 현재 000번 카트 이용중입니다."
        }else{
            Toast.makeText(this,"ID/PW를 확인해주세요",Toast.LENGTH_SHORT).show()
        }


    }
}