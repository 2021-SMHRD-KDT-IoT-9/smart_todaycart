package com.example.todaycart

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {

    // on below line we are creating variables for
    // our swipe to refresh layout, recycler view,
    // adapter and list.
    lateinit var rcvList: RecyclerView
    lateinit var searchAdapter: SearchAdapter
    lateinit var searchList: ArrayList<ProductVO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // on below line we are initializing our views with their ids.
        rcvList = findViewById(R.id.rcvList)

        // on below line we are initializing our list
        searchList = ArrayList()

        // on below line we are initializing our adapter
        searchAdapter = SearchAdapter(searchList)

        // on below line we are setting adapter to our recycler view.
        rcvList.adapter = searchAdapter

        // on below line we are adding data to our list
        searchList.add(ProductVO(R.drawable.beer, "테라", "2000원", "주류 1-2"))
        searchList.add(ProductVO(R.drawable.cida, "칠성사이다","2000원", "음료 1-3"))
        searchList.add(ProductVO(R.drawable.pepsi, "펩시","2000원", "음료 1-3"))
        searchList.add(ProductVO(R.drawable.snack, "오감자","1500원","스낵류 2-2"))


        // on below line we are notifying adapter
        // that data has been updated.
        searchAdapter.notifyDataSetChanged()

    }

    // calling on create option menu
    // layout to inflate our menu file.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // below line is to get our inflater
        val inflater = menuInflater

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.search_menu, menu)

        // below line is to get our menu item.
        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)

        // getting search view of our item.
        val searchView: SearchView = searchItem.getActionView() as SearchView

        // below line is to call set on query text listener method.
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(msg)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {
        // creating a new array list to filter our data.
        val filteredlist: ArrayList<ProductVO> = ArrayList()

        // running a for loop to compare elements.
        for (item in searchList) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.name.toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            searchAdapter.filterList(filteredlist)
        }
    }
}










