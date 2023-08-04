package com.example.selectcarapp.domain

import com.example.selectcarapp.data.Car
import com.example.selectcarapp.data.CarsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarsRepository @Inject constructor(private val historyDao: CarsDao) {

    val readAll: Flow<List<Car>> = historyDao.readAll()

    fun insertItem(employee: Car) {
        historyDao.insertItem(employee)
    }
    fun deleteAll() {
        historyDao.deleteAll()
    }

}