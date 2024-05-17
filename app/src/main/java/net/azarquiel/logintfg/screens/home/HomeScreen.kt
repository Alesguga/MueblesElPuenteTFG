package net.azarquiel.logintfg.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.azarquiel.logintfg.R
import net.azarquiel.logintfg.screens.home.components.Card1
import net.azarquiel.logintfg.screens.home.components.Card2
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisCC

@Composable
fun HomeScreen(navController: NavController) {
    MueblesElPuenteAppTFGTheme {
            HomeContent(navController)
    }
}

@Composable
fun HomeContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grisCC)
            .padding(10.dp, 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.logomep),
            contentDescription = "Logo de Muebles El Puente",
            modifier = Modifier.size(160.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))
        Card1(navController)
        Card2(navController)

    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MueblesElPuenteAppTFGTheme {
        HomeScreen(navController = NavController(context = LocalContext.current))
    }
}
