package com.example.gasprice.data

import com.example.gasprice.model.Main
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    //"https://api.collectapi.com/gasPrice/turkeyGasoline?city=burdur/"

    @GET("gasPrice/turkeyGasoline")
    fun getMainWithQuery(
        @Header("authorization") token: String,
        @Query("city") city: String): Call<Main>

}

