package com.example.selectcarapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Car::class], version = 1, exportSchema = true)
abstract class CarsDatabase: RoomDatabase() {
    abstract fun carsDao(): CarsDao

}