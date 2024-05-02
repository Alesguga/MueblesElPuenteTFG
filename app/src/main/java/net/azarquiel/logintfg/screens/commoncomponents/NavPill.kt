package net.azarquiel.logintfg.screens.commoncomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.azarquiel.logintfg.R
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisC
import net.azarquiel.logintfg.ui.theme.grisO

@Composable
fun NavPill(screenName : String, modifier: Modifier = Modifier){

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = 5.dp, vertical = 12.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(50)
    ) {
        Row(
            modifier = Modifier
                .background(grisC)
                .padding(horizontal = 80.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logomep),
                contentDescription = "albaranes",
                modifier = Modifier
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.width(50.dp))
            Text(
                text = screenName,
                style = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
                fontSize = 18.sp,
                color = grisO
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun PreviewNav(){
    MueblesElPuenteAppTFGTheme {
        NavPill("Albaranes de envio")
    }
}