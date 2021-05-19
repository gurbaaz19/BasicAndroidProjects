package com.projectfire.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.projectfire.recyclerview.DataModel
import com.projectfire.recyclerview.R
import kotlinx.android.synthetic.main.item_another2_row.view.*
import kotlinx.android.synthetic.main.item_another_row.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class ItemAdapter(val context: Context, val items: ArrayList<DataModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ZERO = 0
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == VIEW_TYPE_ZERO) {
            return ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_row, parent, false
                )
            )
        } else if (viewType == VIEW_TYPE_ONE){
            return AnotherViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_another_row, parent, false
                )
            )
        }else{
            return Another2ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_another2_row, parent, false
                )
            )
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.tv_item_name
        val cardViewItem: CardView = view.card_view_item

    }

    class AnotherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAnotherItem: TextView = view.tv_item_name_2
        val cardViewAnotherItem: CardView = view.card_view_item_2

    }

    class Another2ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAnother2Item: TextView = view.tv_item_name_3
        val cardViewAnother2Item: CardView = view.card_view_item_3

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if (holder is ViewHolder) {
            holder.tvItem.text = item.itemName

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
        } else if (holder is AnotherViewHolder) {
            holder.tvAnotherItem.text = item.itemName

            if (position % 2 == 0) {
                holder.cardViewAnotherItem.setBackgroundColor(
                    ContextCompat.getColor(
                        context, R.color.colorLightGray
                    )
                )
            } else {
                holder.cardViewAnotherItem.setBackgroundColor(
                    ContextCompat.getColor(
                        context, R.color.white
                    )
                )
            }
        }
        else if (holder is Another2ViewHolder) {
            holder.tvAnother2Item.text = item.itemName

            if (position % 2 == 0) {
                holder.cardViewAnother2Item.setBackgroundColor(
                    ContextCompat.getColor(
                        context, R.color.colorLightGray
                    )
                )
            } else {
                holder.cardViewAnother2Item.setBackgroundColor(
                    ContextCompat.getColor(
                        context, R.color.white
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    override fun getItemCount(): Int {
        return items.size
    }
}