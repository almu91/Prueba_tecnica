package com.example.pruebatecnica.data.model

import com.google.gson.annotations.SerializedName

data class Organization(
    @SerializedName("accesibility")
    val accesibility: String,
    @SerializedName("services")
    val services: String,
    @SerializedName("schedule")
    val schedule: String,
    @SerializedName("organization-name")
    val organizationName: String,
    @SerializedName("organization-desc")
    val organizationDesc: String
)
