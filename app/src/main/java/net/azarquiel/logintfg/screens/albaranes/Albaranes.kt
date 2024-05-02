package net.azarquiel.logintfg.screens.albaranes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import net.azarquiel.logintfg.screens.albaranes.components.CalendarioMes
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import java.time.LocalDate
import java.time.YearMonth


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun Albaranes() {
    MueblesElPuenteAppTFGTheme {
        NavPill(screenName = "Albaranes de envío")
        AlbaranesContent()
    }
}

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun AlbaranesContent() {
    val db = Firebase.firestore
    val fechaSeleccionada by remember { mutableStateOf(LocalDate.now()) }
    val diasOcupados = remember { mutableStateListOf<LocalDate>() }

    // Cargar días ocupados al iniciar
    LaunchedEffect(Unit) {
        db.collection("diasOcupados").get().addOnSuccessListener { snapshot ->
            diasOcupados.clear()
            snapshot.documents.forEach { doc ->
                doc.getString("fecha")?.let {
                    diasOcupados.add(LocalDate.parse(it))
                }
            }
        }
    }

    CalendarioMes(
        mes = YearMonth.from(fechaSeleccionada),
        diasOcupados = diasOcupados,
        onDiaSeleccionado = { fecha ->
            val esOcupado = diasOcupados.contains(fecha)
            if (esOcupado) {
                diasOcupados.remove(fecha)
                db.collection("diasOcupados").document(fecha.toString()).delete()
            } else {
                diasOcupados.add(fecha)
                db.collection("diasOcupados").document(fecha.toString())
                    .set(mapOf("fecha" to fecha.toString(), "esOcupado" to true))
            }
        }
    )
}


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Preview (showBackground = true)
@Composable
fun PreviewAlbaranes() {
    MueblesElPuenteAppTFGTheme {
        Albaranes()
    }
}