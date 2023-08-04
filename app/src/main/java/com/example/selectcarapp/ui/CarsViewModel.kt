package com.example.selectcarapp.ui

import androidx.lifecycle.ViewModel
import com.example.selectcarapp.data.Car
import com.example.selectcarapp.domain.CarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarsViewModel @Inject constructor(private val repository: CarsRepository) : ViewModel() {

    val readAll: Flow<List<Car>> = repository.readAll

    fun insertItem(item: Car) = CoroutineScope(Dispatchers.IO).launch {
        repository.insertItem(item)
    }

    fun deleteAll() = CoroutineScope(Dispatchers.IO).launch {repository.deleteAll()}

}