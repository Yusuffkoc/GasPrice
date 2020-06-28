package com.example.gasprice.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gasprice.R
import com.example.gasprice.data.ApiClient
import com.example.gasprice.model.Main
import com.example.gasprice.ui.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var tv: TextView
    private val apiClient by lazy { ApiClient.getApiClient() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tv = toolbar.findViewById<TextView>(R.id.toolbarText)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        getData()
        //tv.text = Main().lastupdate


    }

    private fun getData() {
        apiClient.getMainWithQuery("apikey 5sAtslnQW7iShTJBVzM84u:0LtqN721wmNS0R5wsXriyd", "burdur")
            .enqueue(object : Callback<Main> {
                override fun onResponse(call: Call<Main>, response: Response<Main>) {


                    if (response.isSuccessful) {
                        tv.text = response.body()?.lastupdate
                        Toast.makeText(this@MainActivity, "Successfull", Toast.LENGTH_SHORT).show()
                        recyclerView.adapter = UserAdapter(response.body()?.result!!)

                    }
                }

                override fun onFailure(call: Call<Main>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
                }
            })
    }


}

