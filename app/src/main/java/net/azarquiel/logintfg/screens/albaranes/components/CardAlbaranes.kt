package net.azarquiel.logintfg.screens.albaranes.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisC
import net.azarquiel.logintfg.ui.theme.grisCC

@Composable
fun CardAlbaranes() {
    Card(
        modifier = Modifier
            .padding(10.dp,10.dp,10.dp,10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = grisC,
            disabledContainerColor = grisCC,
            contentColor = Color.White,
        )
    ) {
        Column(
            modifier = Modifier
                .height(100.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Listado de facturas mensuales",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewCardAlbaranes() {

    MueblesElPuenteAppTFGTheme {
        CardAlbaranes()
    }
}