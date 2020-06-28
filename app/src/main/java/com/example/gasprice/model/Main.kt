package com.example.gasprice.model

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("lastupdate")
    public val lastupdate: String,
    @SerializedName("result")
    val result: List<Result>,
    @SerializedName("success")
    val success: Boolean
)