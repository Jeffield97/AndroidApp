package com.example.myapplication.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.myapplication.viewModel.UserViewModel

@Composable
fun UserListScreen(viewModel: UserViewModel)
{
    val users by viewModel.users.observeAsState(emptyList())

    LaunchedEffect(true) {
        viewModel.getUsers()
    }

    LazyColumn {
        items(users) { user ->
            UserItem(user)
        }
    }
}