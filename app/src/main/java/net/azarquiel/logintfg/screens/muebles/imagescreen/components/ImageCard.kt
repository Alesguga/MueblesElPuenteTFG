package net.azarquiel.logintfg.screens.muebles.imagescreen.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import net.azarquiel.logintfg.ui.theme.grisC

@Composable
fun ImageCard(imageUrl: String, navController: NavController) {
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
                val encodedUrl = Uri.encode(imageUrl)
                navController.navigate("imageDetail/$encodedUrl")
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(grisC)
                .padding(10.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(5.dp))
            )
        }
    }
}
