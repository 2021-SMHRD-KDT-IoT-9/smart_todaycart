package com.example.todaycart

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        val btnGoBack : Button = findViewById(R.id.btnGoBack)
        val queue : RequestQueue = Volley.newRequestQueue(this)
        val url = "http://119.200.31.135:9090/project/call"
        Request.Method.GET

        btnGoBack.setOnClickListener {
            val intent = Intent(this, Main_AfterActivity::class.java)
            startActivity(intent)
        }

    }
}