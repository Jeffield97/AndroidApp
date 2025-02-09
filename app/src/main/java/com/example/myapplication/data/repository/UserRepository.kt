package com.example.myapplication.data.repository

import com.example.myapplication.data.model.User
import com.example.myapplication.data.service.ApiService

class UserRepository (private val apiService:ApiService){
    suspend fun getUsers():List<User>
    {
        return apiService.getUsers();
    }
}