package com.example.myapplication.data.service

import com.example.myapplication.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers():List<User>;

}