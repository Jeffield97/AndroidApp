package com.example.myapplication.view

import android.media.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.myapplication.R
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.navigation.Destination

@Composable
fun BottomNavigationBar(navController:NavController)
{
    val destinations= listOf(
        Destination.Home,
        Destination.Profile,
        Destination.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute=navBackStackEntry?.destination?.route

    NavigationBar(){
        destinations.forEach{destination ->
            NavigationBarItem(
               icon = {
                   Icon(
                       imageVector = ImageVector.vectorResource(id=getIconForDestination(destination)),
                       contentDescription = destination.title
                   )
               },
                label = { Text(text = destination.title) },
                selected = currentRoute==destination.route,
                onClick = {
                    navController.navigate(destination.route){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop=true
                    }
                },
                modifier = Modifier.fillMaxHeight(.03F)
            )
        }
    }
}

// Función para obtener el ícono correspondiente a cada destino
fun getIconForDestination(destination: Destination): Int {
    return when (destination) {
        Destination.Home -> R.drawable.baseline_person_24 // Reemplaza con tu ícono
        Destination.Profile -> R.drawable.outline_add_shopping_cart_24 // Reemplaza con tu ícono
        Destination.Settings -> R.drawable.baseline_chat_24 // Reemplaza con tu ícono
    }
}