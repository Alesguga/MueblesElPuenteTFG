package net.azarquiel.logintfg.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.azarquiel.logintfg.R
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisC
import net.azarquiel.logintfg.ui.theme.grisCC

@Composable
fun Card2(){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { }
            .fillMaxWidth(),

        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = grisC,
            disabledContainerColor = grisCC,
            contentColor = Color.White

        )
    ){
        Spacer(modifier = Modifier
            .padding(12.dp)
        )
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Exposición",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 28.sp
                )
            )
        }
        Column (
            modifier = Modifier
                .padding(25.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dorhome1),
                contentDescription = "Logomep",
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .fillMaxWidth()
            )

        }

    }
}

@Preview(showBackground = false)
@Composable
fun PreviewCard2(){
    MueblesElPuenteAppTFGTheme {
        Card2()
    }
}