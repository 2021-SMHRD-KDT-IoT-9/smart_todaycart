package com.example.todaycart


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etId : EditText = findViewById(R.id.etId)
        val etPw : EditText = findViewById(R.id.etPw)
        val btnDoLogin : Button = findViewById(R.id.btnDoLogin)


        btnDoLogin.setOnClickListener {
           val intent = Intent(this,Main_AfterActivity::class.java)
            intent.putExtra("id", etId.text.toString())
            intent.putExtra("pw", etPw.text.toString())
            startActivity(intent)
            finish()
        }

        }
    }
