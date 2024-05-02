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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisC
import net.azarquiel.logintfg.ui.theme.grisCC
import net.azarquiel.logintfg.ui.theme.grisO
import net.azarquiel.logintfg.ui.theme.naranjaMEP
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
        Column(modifier = Modifier
            .padding(8.dp ,80.dp, 8.dp, 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(grisC)
        ) {
            Text(
                text = "${
                    mes.month.getDisplayName(
                        TextStyle.FULL,
                        Locale.getDefault()
                    )
                } ${mes.year}",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.CenterHorizontally),
                color = grisO
            )

            // Días de la semana
            Row(modifier = Modifier.fillMaxWidth()) {
                listOf("L", "M", "X", "J", "V", "S", "D").forEach { dia ->
                    Text(
                        text = dia, modifier = Modifier
                            .padding(8.dp)
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        color = grisCC
                    )
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
                                .clip(RoundedCornerShape(4.dp))
                                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(4.dp))
                                .background(if (dia.esOcupado) naranjaMEP else Color.Transparent)
                                .clickable { onDiaSeleccionado(dia.fecha) }
                        ) {
                            Text(
                                text = dia.fecha.dayOfMonth.toString(),
                                modifier = Modifier
                                    .padding(6.dp)
                                    .background(if (dia.esOcupado) naranjaMEP else Color.Transparent),
                                textAlign = TextAlign.Center,
                                color = if (dia.esOcupado) grisO else Color.White
                            )
                            Spacer(modifier = Modifier.padding(20.dp))
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(4.dp))

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