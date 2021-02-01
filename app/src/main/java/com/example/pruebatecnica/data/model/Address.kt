package com.example.pruebatecnica.data.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("locality")
    var locality: String?,
    @SerializedName("street-address")
    var streetAddress: String?,
    @SerializedName("postal-code")
    var postalCode: String?
)
