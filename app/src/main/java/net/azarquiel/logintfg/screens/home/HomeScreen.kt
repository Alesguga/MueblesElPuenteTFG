package net.azarquiel.logintfg.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.azarquiel.logintfg.R
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.screens.home.components.Card1
import net.azarquiel.logintfg.screens.home.components.Card2
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisO

@Composable
fun HomeScreen() {
    MueblesElPuenteAppTFGTheme {
            HomeContent()
    }
}

@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grisO)
            .padding(10.dp, 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.logomep),
            contentDescription = "Logo de Muebles El Puente",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))
        Card1()
        Card2()

    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MueblesElPuenteAppTFGTheme {
        HomeScreen()
    }
}
