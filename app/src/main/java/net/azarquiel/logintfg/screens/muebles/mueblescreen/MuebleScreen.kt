package net.azarquiel.logintfg.screens.muebles.mueblescreen

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
import net.azarquiel.logintfg.screens.muebles.mueblescreen.components.SubfolderCard
import net.azarquiel.logintfg.viewmodel.MainViewModel

@Composable
fun MuebleScreen(navController: NavController, folderName: String?) {
    MueblesElPuenteAppTFGTheme {
        val viewModel: MainViewModel = viewModel()
        val subfolders by viewModel.getFoldersByStyle(folderName ?: "").observeAsState(emptyList())

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
        ) {
            NavPill(screenName = "$folderName")
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(subfolders.size) { index ->
                    SubfolderCard(
                        navController,
                        folderName = folderName ?: "",
                        subfolderName = subfolders[index]
                    )
                }
            }
        }
    }
}


