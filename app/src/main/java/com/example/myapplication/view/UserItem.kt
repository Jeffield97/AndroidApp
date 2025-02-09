package com.example.myapplication.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.model.User

@Composable
fun UserItem(user:User)
{
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Name: ${user.name}")
        Text(text = "Username: ${user.username}")
        Text(text = "Email: ${user.email}")
        Text(text = "Phone: ${user.phone}")
        Text(text = "Website: ${user.website}")

    }
}