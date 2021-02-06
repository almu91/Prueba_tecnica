package com.example.pruebatecnica.data.model

import com.google.gson.annotations.SerializedName

data class MunicipalCenter(
    @SerializedName("location")
    var location: Location?,
    @SerializedName("relation")
    var relation: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("organization")
    var organization: Organization?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("address")
    var address: Address?,
)
