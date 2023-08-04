package com.example.selectcarapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "new_db")
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val brand: String,
    val model: String,

    )
