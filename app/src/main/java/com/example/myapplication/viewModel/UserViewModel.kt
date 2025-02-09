package com.example.myapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.api.RetrofitInstance
import com.example.myapplication.data.model.User
import com.example.myapplication.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    private val userRepository = UserRepository(RetrofitInstance.apiService)

    fun getUsers() {
        viewModelScope.launch {
            try {
                val userList = userRepository.getUsers()  // Obtiene los usuarios desde el repositorio
                _users.value = userList
            } catch (e: Exception) {
                // Manejo de errores
                e.printStackTrace()
            }
        }
    }
}