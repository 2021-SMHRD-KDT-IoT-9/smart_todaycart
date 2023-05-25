package com.example.todaycart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    private lateinit var queue: RequestQueue
    private lateinit var etId: EditText
    private lateinit var etPw: EditText
    private lateinit var btnDoLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etId = findViewById(R.id.etId)
        etPw = findViewById(R.id.etPw)
        btnDoLogin = findViewById(R.id.btnDoLogin)

        queue = Volley.newRequestQueue(applicationContext)

        btnDoLogin.setOnClickListener {
            val url = "http://119.200.31.135:9090/project/loginCheckMember"
            // http://119.200.31.135:9090/project/loginCheckMember
            val id = etId.text.toString()
            val pw = etPw.text.toString()
            if (id.isNotEmpty() && pw.isNotEmpty()) {
                val params = HashMap<String, String>()
                params["id"] = id
                params["pw"] = pw

                val request = object : StringRequest(
                    Request.Method.POST,
                    url,
                    Response.Listener<String> { response ->
                        val json = JSONObject(response)
                        val success = json.getBoolean("success")
                        val message = json.getString("message")

                        if (success) {
                            val intent = Intent(this@LoginActivity, Main_AfterActivity::class.java)
                            intent.putExtra("id", id)
                            intent.putExtra("pw", pw)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                        }
                    },
                    Response.ErrorListener { error -> error.printStackTrace()
                        Toast.makeText(this, "서버 통신 실패", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    override fun getParams(): Map<String, String> {
                        return params
                    }
                }

                queue.add(request)
            } else {
                Toast.makeText(this, "아이디/비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}