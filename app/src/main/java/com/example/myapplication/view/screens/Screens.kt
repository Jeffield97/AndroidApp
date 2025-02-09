package com.example.myapplication.view.screens

import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ListUsers
import com.example.myapplication.view.UserListScreen
import com.example.myapplication.viewModel.UserViewModel

//private val userViewModel: UserViewModel by viewModels()

@Composable
fun HomeScreen()
{
    val usuarios = List(250) { "User $it" }
    ListUsers(innerPadding = PaddingValues(1.dp),usuarios)
}

@Composable
fun ProfileScreen(userViewModel: UserViewModel= viewModel())
{
    Scaffold(modifier = Modifier.padding(0.dp)) { innerPadding ->
        UserListScreen(viewModel = userViewModel)
    }
}

@Composable
fun SettingsScreen()
{
    Text("Settings Screen")
}
