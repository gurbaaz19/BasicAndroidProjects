package com.projectfire.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.projectfire.recyclerview.R
import kotlinx.android.synthetic.main.item_row.view.*

class ItemAdapter(val context: Context, val items: ArrayList<String>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_row, parent, false
            )
        )
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.tv_item_name
        val cardViewItem: CardView = view.card_view_item

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvItem.text = item

        if (position % 2 == 0) {
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(
                    context, R.color.colorLightGray
                )
            )
        } else {
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(
                    context, R.color.white
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}