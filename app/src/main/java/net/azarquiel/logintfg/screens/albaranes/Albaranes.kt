package net.azarquiel.logintfg.screens.albaranes

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import net.azarquiel.logintfg.screens.albaranes.components.CalendarioMes
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter


@Composable
fun Albaranes() {
    MueblesElPuenteAppTFGTheme {
        AlbaranesContent()
    }
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun AlbaranesContent() {
    var fechaSeleccionada by remember { mutableStateOf(LocalDate.now()) }
    val diasOcupados = remember { mutableStateListOf<LocalDate>() }
    CalendarioMes(
        mes = YearMonth.from(fechaSeleccionada),
        diasOcupados = diasOcupados,
        onDiaSeleccionado = { fecha ->
            fechaSeleccionada = fecha
            val esOcupado = diasOcupados.contains(fecha)
            if (esOcupado) {
                diasOcupados.remove(fecha)
            } else {
                diasOcupados.add(fecha)
            }
        }
    )
}


@Preview
@Composable
fun PreviewAlbaranes() {
    MueblesElPuenteAppTFGTheme {
        Albaranes()
    }
}