package com.example.pruebatecnica.data.connections

class ApiHelper(private val apiService: MunicipalCentersService) {
    suspend fun getFixedCleanPoints() = apiService.getFixedCleanPoints()

    suspend fun getInfoCenters() = apiService.getInfoCenters()
}