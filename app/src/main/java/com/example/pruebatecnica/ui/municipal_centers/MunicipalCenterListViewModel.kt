package com.example.pruebatecnica.ui.municipal_centers

import androidx.lifecycle.*
import com.example.pruebatecnica.data.model.ParentCenters
import com.example.pruebatecnica.data.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MunicipalCenterListViewModel(val mainRepository: MainRepository) : ViewModel() {

    private val _cleanPointCenters = MutableLiveData<ParentCenters?>()
    val cleanPointCenters: LiveData<ParentCenters?>
        get() = _cleanPointCenters

    private val _infoCenters = MutableLiveData<ParentCenters?>()
    val infoCenters: LiveData<ParentCenters?>
        get() = _infoCenters


    fun initData() {
        viewModelScope.launch {

            val resultCleanPoints = async(Dispatchers.IO) {
                mainRepository.getFixedCleanPoints()
            }

             val resultInfoPoints = async(Dispatchers.IO) {
                mainRepository.getInfoCenters()
            }

            _cleanPointCenters.value = resultCleanPoints.await()
            _infoCenters.value = resultInfoPoints.await()
        }
    }
}