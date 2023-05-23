package joinfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.todaycart.R
import kotlin.io.path.fileVisitor

class StepOneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_step_one, container, false)
        val etInputId : EditText = view.findViewById(R.id.etInputId)
        val btnNext : Button = view.findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            if (etInputId != null){
                val intent = Intent(context, StepTwoFragment::class.java)
                startActivity(intent)
            }else if (etInputId == null){
                Toast.makeText(context,"아이디를 입력하세요",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }

}

