package net.azarquiel.logintfg.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.azarquiel.logintfg.screens.albaranes.Albaranes
import net.azarquiel.logintfg.screens.facturasMensuales.Facturas
import net.azarquiel.logintfg.screens.home.HomeScreen
import net.azarquiel.logintfg.screens.login.components.LoginContent
import net.azarquiel.logintfg.screens.muebles.folderscreen.FolderScreen

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginContent(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("albaranes") {
            Albaranes(navController)
        }
        composable("facturas"){
            Facturas()
        }
        composable("folder") {
            FolderScreen(navController)
        }
    }
}

