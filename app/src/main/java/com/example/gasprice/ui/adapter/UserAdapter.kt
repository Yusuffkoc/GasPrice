package com.example.gasprice.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gasprice.R
import com.example.gasprice.model.Main
import kotlinx.android.synthetic.main.item.view.*

class UserAdapter(var userList: List<Main>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val benzinMarka = itemView.findViewById<TextView>(R.id.markaId)
        val benzinFiyat = itemView.findViewById<TextView>(R.id.benzinFiyatId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.benzinFiyat.text=userList[position].result.benzinDeger.toString()
    holder.benzinMarka.text=userList[position].result.marka
    }


}