package com.example.myapplication.data.api

import com.example.myapplication.data.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    // Define la URL base de la API
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // Crear una instancia de Retrofit
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)  // URL base de la API
            .addConverterFactory(GsonConverterFactory.create())  // Convertir la respuesta JSON
            .build()
            .create(ApiService::class.java)  // Crear una implementación de ApiService
    }
}