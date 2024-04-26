package net.azarquiel.logintfg.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.azarquiel.logintfg.screens.home.HomeScreen
import net.azarquiel.logintfg.screens.login.MainActivity

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){
            MainActivity()
        }
        composable("home"){
            HomeScreen()
        }
    }
}