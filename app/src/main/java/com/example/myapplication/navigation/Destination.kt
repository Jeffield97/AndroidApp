package com.example.myapplication.navigation

sealed class Destination(val route:String,val title:String) {
    object Home:Destination("home","Home")
    object Profile:Destination("profile","Profile")
    object Settings:Destination("settings","Settings")
}