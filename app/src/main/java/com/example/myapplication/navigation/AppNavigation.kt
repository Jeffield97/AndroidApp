package com.example.myapplication.navigation

import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.view.BottomNavigationBar
import com.example.myapplication.view.screens.HomeScreen
import com.example.myapplication.view.screens.ProfileScreen
import com.example.myapplication.view.screens.SettingsScreen
import com.example.myapplication.viewModel.UserViewModel

@Composable
fun AppNavigation()
{
    val navController=rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController=navController) },
    ){
        innerPadding->
        NavHost(
            navController=navController,
            startDestination = Destination.Home.route,
            modifier = Modifier.padding(innerPadding)
        )
        {
            composable (Destination.Home.route){ HomeScreen() }
            composable (Destination.Profile.route){ ProfileScreen() }
            composable (Destination.Settings.route){ SettingsScreen() }
        }
    }
}