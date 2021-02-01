package com.example.pruebatecnica.data.connections

import com.example.pruebatecnica.data.model.ParentCenters
import retrofit2.http.GET

interface MunicipalCentersService {

    @GET("201105-0-informacion-turismo.json")
    suspend fun getInfoCenters(): ParentCenters

    @GET("200284-0-puntos-limpios-fijos.json")
    suspend fun getFixedCleanPoints(): ParentCenters

}