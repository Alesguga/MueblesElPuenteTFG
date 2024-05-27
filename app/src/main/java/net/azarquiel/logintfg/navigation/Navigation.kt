package net.azarquiel.logintfg.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.azarquiel.logintfg.screens.albaranes.Albaranes
import net.azarquiel.logintfg.screens.facturasMensuales.Facturas
import net.azarquiel.logintfg.screens.facturasMensuales.components.factura
import net.azarquiel.logintfg.screens.home.HomeScreen
import net.azarquiel.logintfg.screens.login.components.LoginContent
import net.azarquiel.logintfg.screens.muebles.folderscreen.FolderScreen
import net.azarquiel.logintfg.screens.muebles.mueblescreen.MuebleScreen
import net.azarquiel.logintfg.screens.muebles.imagescreen.ImageScreen

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
        composable("facturas") {
            Facturas(navController)
        }
        composable(
            route = "factura/{facturaId}",
            arguments = listOf(navArgument("facturaId") { type = NavType.StringType })
        ) { backStackEntry ->
            val facturaId = backStackEntry.arguments?.getString("facturaId")
            factura(facturaId)
        }
        composable("factura") {
            factura(null)
        }
        composable("folder") {
            FolderScreen(navController)
        }
        composable(
            route = "mueble/{folderName}",
            arguments = listOf(navArgument("folderName") { type = NavType.StringType })
        ) {
                backStackEntry ->
            val folderName = backStackEntry.arguments?.getString("folderName")
            MuebleScreen(navController, folderName)
        }
        composable(
            route = "image/{folderName}/{subfolderName}",
            arguments = listOf(
                navArgument("folderName") { type = NavType.StringType },
                navArgument("subfolderName") { type = NavType.StringType }
            )
        ) {
                backStackEntry ->
            val folderName = backStackEntry.arguments?.getString("folderName")
            val subfolderName = backStackEntry.arguments?.getString("subfolderName")
            ImageScreen(navController, folderName, subfolderName)
        }
    }
}
