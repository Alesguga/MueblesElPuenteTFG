package net.azarquiel.logintfg.screens.muebles.imagescreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.screens.muebles.imagescreen.components.ImageCard
import net.azarquiel.logintfg.viewmodel.MainViewModel

@Composable
fun ImageScreen(navController: NavController, folderName: String?, subfolderName: String?) {
    MueblesElPuenteAppTFGTheme {
    val viewModel: MainViewModel = viewModel()
    val images by viewModel.getImagesByStyle("$folderName/$subfolderName").observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        NavPill(screenName = "$subfolderName")
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(images.size) { index ->
                ImageCard(imageUrl = images[index])
            }
        }
    }
    }
}


