package com.example.pruebatecnica.data.repository

import com.example.pruebatecnica.data.connections.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getFixedCleanPoints() = apiHelper.getFixedCleanPoints()

    suspend fun getInfoCenters() = apiHelper.getInfoCenters()
}
