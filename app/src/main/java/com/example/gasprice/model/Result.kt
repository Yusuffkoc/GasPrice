package com.example.gasprice.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("benzin")
    val benzinDeger: String?,
    @SerializedName("marka")
    val marka: String

)