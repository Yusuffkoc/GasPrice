package com.example.gasprice.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
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

    val apiClient = ApiClient.getApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        var tv = toolbar.findViewById<TextView>(R.id.toolbarText)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        getData()
        //tv.text = Main().lastupdate


    }


    private fun getData() {
        apiClient.getMainWithQuery("burdur").enqueue(object : Callback<List<Main>> {
            override fun onFailure(call: Call<List<Main>>, t: Throwable) {

                Log.e("MainActivity", "onFailure: ${t.message}")
            }

            override fun onResponse(call: Call<List<Main>>, response: Response<List<Main>>) {

                if (response.isSuccessful) {
                    //recyclerView.adapter=UserAdapter(response.body()?.)

                    Toast.makeText(this@MainActivity, "Successfull", Toast.LENGTH_SHORT).show()
                }
            }

        })

    }
}
