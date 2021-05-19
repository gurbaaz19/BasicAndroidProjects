package com.projectfire.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.projectfire.recyclerview.adapters.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view_items.layoutManager  = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        recycler_view_items_2.layoutManager  = LinearLayoutManager(this)

        val itemAdapter = ItemAdapter(this,getItemsList())

        recycler_view_items.adapter = itemAdapter
        recycler_view_items_2.adapter = itemAdapter
    }

    private fun getItemsList(): ArrayList<String>{
        val list = ArrayList<String>()

        for (i in 1..15){
            list.add("Item $i")
        }

        return list
    }
}