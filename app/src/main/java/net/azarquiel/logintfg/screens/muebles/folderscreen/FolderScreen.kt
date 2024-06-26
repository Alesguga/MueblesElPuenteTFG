package net.azarquiel.logintfg.screens.muebles.folderscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.screens.muebles.folderscreen.components.FolderCard
import net.azarquiel.logintfg.viewmodel.MainViewModel

@Composable
fun FolderScreen(navController: NavController) {
    MueblesElPuenteAppTFGTheme {
        FolderContent(navController)
    }
}

@Composable
fun FolderContent(navController: NavController) {
    val viewModel: MainViewModel = viewModel()
    val folders by viewModel.getFolders().observeAsState(emptyList())

    Column {
        NavPill(screenName = "Muebles")
        Spacer(modifier = Modifier.height(16.dp))
        FolderList(navController = navController, folders = folders)
    }
}

@Composable
fun FolderList(navController: NavController, folders: List<String>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(folders.size) { index ->
            FolderCard(navController = navController, folderName = folders[index])
        }
    }
}



@Preview(showBackground = true)
@Composable
fun FolderScreenPreview() {
    MueblesElPuenteAppTFGTheme {
        FolderScreen(navController = NavController(context = LocalContext.current))
    }
}
