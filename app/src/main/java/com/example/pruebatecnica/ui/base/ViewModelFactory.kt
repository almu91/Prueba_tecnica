package com.example.pruebatecnica.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pruebatecnica.data.connections.ApiHelper
import com.example.pruebatecnica.data.repository.MainRepository
import com.example.pruebatecnica.ui.municipal_centers.MunicipalCenterListViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MunicipalCenterListViewModel::class.java)) {
            return MunicipalCenterListViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}