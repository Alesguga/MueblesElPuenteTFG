package net.azarquiel.logintfg.screens.muebles.mueblescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.viewmodel.MainViewModel
import net.azarquiel.logintfg.ui.theme.grisC

@Composable
fun MuebleScreen(navController: NavController, folderName: String?) {
    val viewModel: MainViewModel = viewModel()
    val subfolders by viewModel.getFoldersByStyle(folderName ?: "").observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        NavPill(screenName = "$folderName")
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(subfolders.size) { index ->
                SubfolderCard(subfolderName = subfolders[index])
            }
        }
    }
}

@Composable
fun SubfolderCard(subfolderName: String) {
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 1.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
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
