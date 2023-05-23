package com.example.todaycart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment



class StepTwoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_step_two, container, false)
        val etInputPw : EditText = view.findViewById(R.id.etInputPw)
        val etCheckPw: EditText = view.findViewById(R.id.etCheckPw)

            val password = etInputPw.text.toString()
            if (password.length < 6) {
                etInputPw.error = "비밀번호는 최소 6자리 이상이어야 합니다."
            } else {
                // 비밀번호가 조건을 충족한 경우, 회원가입 로직을 진행합니다.
            }




        return view
    }


    }
