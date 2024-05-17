package net.azarquiel.logintfg.screens.muebles

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.viewmodel.MainViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun FolderScreen(navController: NavController) {
    MueblesElPuenteAppTFGTheme {
        FolderContent(navController)
    }
}

@Composable
fun FolderContent(navController: NavController) {
    val viewModel: MainViewModel = viewModel()
    val folders by viewModel.folders.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadFolders()
    }

    Column {
        NavPill(screenName = "Muebles")
        Spacer(modifier = Modifier.height(16.dp))
        FolderList(folders = folders)
    }
}

@Composable
fun FolderList(folders: List<String>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(folders.size) { index ->
            FolderCard(folderUrl = folders[index])
        }
    }
}

@Composable
fun FolderCard(folderUrl: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = folderUrl,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
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
