package com.example.designui.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.designui.R
import kotlinx.android.synthetic.main.item_overview.view.*

class StatusAdapter(val listStatus: List<Status>) : RecyclerView.Adapter<StatusAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bindDataHolder(status: Status) {
            itemView.tvSent.text = status.status
            itemView.tvContentSent.text = status.contentStatus
            itemView.tvPrice.text = status.price
            itemView.imgStatusSent.setImageResource(status.imgStatus)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_overview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindDataHolder(listStatus[position])
    }

    override fun getItemCount(): Int = listStatus.size
}