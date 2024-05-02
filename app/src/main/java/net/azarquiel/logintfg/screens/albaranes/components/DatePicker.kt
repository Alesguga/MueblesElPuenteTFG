package net.azarquiel.logintfg.screens.albaranes.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisC
import net.azarquiel.logintfg.ui.theme.grisCC
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*

data class DiaCalendario(val fecha: LocalDate, val esOcupado: Boolean)

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun CalendarioMes(mes: YearMonth = YearMonth.now(), diasOcupados: List<LocalDate> = listOf(LocalDate.now()), onDiaSeleccionado: (LocalDate) -> Unit = {}) {
    val diasDelMes = remember(mes) { mes.atDay(1).datesUntil(mes.plusMonths(1).atDay(1)).toList() }
    val diasConEstado = diasDelMes.map { fecha ->
        DiaCalendario(fecha, diasOcupados.contains(fecha))
    }

    Column(modifier = Modifier.padding(8.dp)) {
        // Encabezado del calendario
        Text(text = "${mes.month.getDisplayName(TextStyle.FULL, Locale.getDefault())} ${mes.year}",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.CenterHorizontally))

        // Días de la semana
        Row(modifier = Modifier.fillMaxWidth()) {
            listOf("L", "M", "X", "J", "V", "S", "D").forEach { dia ->
                Text(text = dia, modifier = Modifier
                    .padding(4.dp)
                    .weight(1f),
                    textAlign = TextAlign.Center)
            }
        }

        // Filas del calendario
        val semanas = diasConEstado.chunked(7)
        semanas.forEach { semana ->
            Row(modifier = Modifier.fillMaxWidth()) {
                semana.forEach { dia ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .border(BorderStroke(1.dp,grisC), RoundedCornerShape(4.dp))
                            .background(if (dia.esOcupado) Color.Red else Color.Transparent)
                            .clickable { onDiaSeleccionado(dia.fecha) }
                    ) {
                        Text(text = dia.fecha.dayOfMonth.toString(),
                            modifier = Modifier
                                .padding(5.dp)
                                .background(if (dia.esOcupado) Color.Red else Color.Transparent),
                            textAlign = TextAlign.Center,

                        )
                    }
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Preview (showBackground = true)
@Composable
fun PreviewDatePicker() {
    MueblesElPuenteAppTFGTheme {
        CalendarioMes()
    }
}