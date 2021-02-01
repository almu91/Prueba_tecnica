package com.example.pruebatecnica.data.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("longitude")
    var longitude: String,
    @SerializedName("latitude")
    var latitude: String
)
