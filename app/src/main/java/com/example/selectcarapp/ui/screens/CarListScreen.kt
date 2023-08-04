package com.example.selectcarapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.selectcarapp.data.Car
import com.example.selectcarapp.ui.CarsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarListScreen(carsViewModel: CarsViewModel) {
    val carList by carsViewModel.readAll.collectAsState(initial = emptyList())
    var brand by rememberSaveable { mutableStateOf("") }
    var model by rememberSaveable { mutableStateOf("") }

    Column {
        LazyColumn {
            items(carList) { car ->
                Text(text = "Brand: ${car.brand}, Model: ${car.model}")
            }
        }

        OutlinedTextField(
            value = brand,
            onValueChange = { brand = it },
            label = { Text("Brand") },
            modifier = Modifier.padding(all = 8.dp)
        )

        OutlinedTextField(
            value = model,
            onValueChange = { model = it },
            label = { Text("Model") },
            modifier = Modifier.padding(all = 8.dp)
        )

        Button(onClick = {
            if (brand.isNotBlank() && model.isNotBlank()) {
                carsViewModel.insertItem(Car(id = 0, brand = brand, model = model))
                brand = ""
                model = ""
            } else {
                // Show error message
            }
        }, enabled = brand.isNotBlank() && model.isNotBlank()) {
            Text("Add Car")
        }
    }
}
