package com.example.gasprice.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gasprice.R
import com.example.gasprice.model.Main
import com.example.gasprice.model.Result
import kotlinx.android.synthetic.main.activity_main.*

class UserAdapter(var userList: List<Result>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val benzinMarka = itemView.findViewById<TextView>(R.id.markaId)
        val benzinFiyat = itemView.findViewById<TextView>(R.id.benzinFiyatId)

        //val toolbarTitle=itemView.findViewById<TextView>(R.id.toolbarText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.benzinFiyat.text= userList[position].benzinDeger.toString()
    holder.benzinMarka.text=userList[position].marka
        //holder.toolbarTitle.text=Class<List<Main>>.
    }


}