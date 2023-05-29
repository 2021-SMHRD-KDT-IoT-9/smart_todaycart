package com.example.todaycart

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class JoinThreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_join_three, container, false)
        val etTel : EditText = view.findViewById(R.id.etTel)
        val btnThree : Button = view.findViewById(R.id.btnThree)

        btnThree.setOnClickListener {
            val tel = etTel.text.toString()
            if (tel != ""){
                val activity = activity as JoinActivity
                activity.replaceFragment(JoinFourFragment())
                val sf = requireActivity().getSharedPreferences("join", Context.MODE_PRIVATE)
                val editor : SharedPreferences.Editor = sf.edit()
                // editor에 etUrl에 있는 값을 저장 : Key/value
                editor.putString("tel", tel)
                editor.commit()

                val sf2 = requireActivity().getSharedPreferences("join", Context.MODE_PRIVATE)
                val tel2 = sf2.getString("tel", "error_tel")
            }else if (tel == ""){
                Toast.makeText(context,"휴대전화 번호를 입력하세요",Toast.LENGTH_SHORT).show()
            }

        }



        return view
    }


}