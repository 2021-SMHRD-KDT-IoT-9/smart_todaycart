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
import android.widget.RadioGroup


class JoinFourFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_join_four, container, false)
        val btnFour : Button = view.findViewById(R.id.btnFour)
        val rgGender : RadioGroup = view.findViewById(R.id.rgGender)
        val btnMale : Button = view.findViewById(R.id.btnMale)
        val btnFemale : Button = view.findViewById(R.id.btnFemale)
        val etAdd : EditText = view.findViewById(R.id.etAdd)

        btnFour.setOnClickListener {
            val address = etAdd.text.toString()

            if (address != ""){
                val activity = activity as JoinActivity
                activity.replaceFragment(JoinFiveFragment())
                val sf = requireActivity().getSharedPreferences("join", Context.MODE_PRIVATE)
                val editor : SharedPreferences.Editor = sf.edit()

                editor.putString("address", address)
                editor.commit()

                val sf2 = requireActivity().getSharedPreferences("join", Context.MODE_PRIVATE)
                val address2 = sf2.getString("address", "error_address")

            }
        }

        return view
    }


}