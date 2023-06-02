package com.example.todaycartapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View.OnKeyListener
import android.widget.Button

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        lateinit var rcvList: RecyclerView
        lateinit var searchAdapter: SearchAdapter
        lateinit var searchList: ArrayList<ProductVO>
        lateinit var totalList: ArrayList<ProductVO>

            val etSearch = findViewById<EditText>(R.id.etSearch)
            val btnBackPage : ImageButton = findViewById(R.id.btnBackPage)
            val btnSearching : ImageButton = findViewById(R.id.btnSearching)


            rcvList = findViewById(R.id.rcvList)


            searchList = ArrayList()
            totalList = ArrayList()



            searchAdapter = SearchAdapter(searchList)


            rcvList.adapter = searchAdapter
            rcvList.layoutManager = LinearLayoutManager(this)


            totalList.add(ProductVO(R.drawable.beer, "테라", "2000원", "주류 1-2"))
            totalList.add(ProductVO(R.drawable.cida, "칠성사이다","2000원", "음료 1-3"))
            totalList.add(ProductVO(R.drawable.pepsi, "펩시","2000원", "음료 1-3"))
            totalList.add(ProductVO(R.drawable.snack, "오감자","1500원","스낵류 2-2"))
            totalList.add(ProductVO(R.drawable.beer, "tera", "2000원", "주류 1-2"))
            totalList.add(ProductVO(R.drawable.cida, "cider","2000원", "음료 1-3"))
            totalList.add(ProductVO(R.drawable.pepsi, "pepsi","2000원", "음료 1-3"))
            totalList.add(ProductVO(R.drawable.snack, "oh","1500원","스낵류 2-2"))
            totalList.add(ProductVO(R.drawable.beer, "tete", "2000원", "주류 1-2"))
            totalList.add(ProductVO(R.drawable.cida, "ambasa","2000원", "음료 1-3"))
            totalList.add(ProductVO(R.drawable.pepsi, "pokari","2000원", "음료 1-3"))
            totalList.add(ProductVO(R.drawable.snack, "ohoh","1500원","스낵류 2-2"))


            etSearch.setOnKeyListener(object : OnKeyListener{
                override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {

                    searchList.clear()

                    val input = etSearch.text.toString()


                    for(i in 0 until totalList.size){
                        if(totalList.get(i).name.contains(input)){
                            searchList.add(totalList.get(i))
                        }
                    }
                    searchAdapter.notifyDataSetChanged()

                    return false
                }
            })


//            btnBackPage.setOnClickListener {
//                val intent = Intent(this,Main_AfterActivity::class.java)
//                startActivity(intent)
//            }
        }
    }


