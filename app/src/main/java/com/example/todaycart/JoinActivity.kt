package com.example.todaycart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val fl : FrameLayout = findViewById(R.id.fl)
        val btnNext : Button = findViewById(R.id.btnNext)
        val fragmentList = arrayOf(StepTwoFragment(), StepThreeFragment(), StepFourFragment(), LastStepFragment())
        var cnt : Int = 1


            supportFragmentManager.beginTransaction().replace(
                R.id.fl,
                StepOneFragment()
            ).commit()

        btnNext.setOnClickListener {

            cnt += 1

            if (cnt == 2){
                val one:EditText = findViewById(R.id.etInputId)
                if(one != null){
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        fragmentList[0]
                    ).commit()
                }else{
                    cnt -= 1
                    Toast.makeText(this,"아이디를 입력하세요",Toast.LENGTH_SHORT).show()

                }
            }
            if (cnt == 3){
                val pass : EditText = findViewById(R.id.etInputPw)
                val pass2 :EditText = findViewById(R.id.etCheckPw)
                if(pass == pass2){
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fl,
                        fragmentList[1]
                    ).commit()
                }else{

                    Toast.makeText(this,"비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            if (cnt == 4){
                btnNext.text = "회원가입"
                supportFragmentManager.beginTransaction().replace(
                    R.id.fl,
                    fragmentList[2]
                ).commit()
            }
            if (cnt == 5){
                btnNext.text = "홈으로"
                supportFragmentManager.beginTransaction().replace(
                    R.id.fl,
                    fragmentList[3]
                ).commit()
            }
            if (cnt == 6){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }


    }
}