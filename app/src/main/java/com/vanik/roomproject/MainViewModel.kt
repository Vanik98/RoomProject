package com.vanik.roomproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vanik.roomproject.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(activity: MainActivity) : ViewModel() {

    private val repository = Repository(activity)

    fun insertData() = viewModelScope.launch {
        try {
            repository.insertData()
        } catch (e: java.lang.Exception) {

        }
    }

    fun deleteCar(userID: String, carID: String) = viewModelScope.launch {
        try {
            repository.deleteCar(userID, carID)
        } catch (e: java.lang.Exception) {

        }
    }

    fun updateCar(userID: String, carID: String) = viewModelScope.launch {
        try {
            repository.updateCar(userID, carID)
        } catch (e: java.lang.Exception) {

        }
    }
}