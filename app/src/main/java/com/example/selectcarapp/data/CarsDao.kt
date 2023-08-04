package com.example.selectcarapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CarsDao {
    @Query("SELECT * FROM new_db")
    fun readAll(): Flow<List<Car>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(history: Car)

    @Delete
    fun deleteItem(history: Car)

    @Query("DELETE FROM new_db")
    fun deleteAll()

}