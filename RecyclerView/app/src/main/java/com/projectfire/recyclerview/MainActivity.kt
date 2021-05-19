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

        recycler_view_items.layoutManager  = LinearLayoutManager(this)

        val itemAdapter = ItemAdapter(this,getItemsList())

        recycler_view_items.adapter = itemAdapter
    }

    private fun getItemsList(): ArrayList<DataModel>{
        val list = ArrayList<DataModel>()

        for (i in 1..45){
            list.add(DataModel("Item $i ViewType ${i%3-1}", i%3-1))
        }

        return list
    }
}