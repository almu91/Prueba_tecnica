package com.example.pruebatecnica.data.model

import com.google.gson.annotations.SerializedName

data class ParentCenters(

    @SerializedName("@graph")
    var centers: List<MunicipalCenter>?
)
