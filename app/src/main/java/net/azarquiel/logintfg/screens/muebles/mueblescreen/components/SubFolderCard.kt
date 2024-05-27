package net.azarquiel.logintfg.screens.muebles.mueblescreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import net.azarquiel.logintfg.ui.theme.grisC

@Composable
fun SubfolderCard(navController: NavController, folderName: String, subfolderName: String) {
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { navController.navigate("image/$folderName/$subfolderName") }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(grisC)
                .padding(16.dp)
        ) {
            Text(
                text = subfolderName,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 22.sp
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}