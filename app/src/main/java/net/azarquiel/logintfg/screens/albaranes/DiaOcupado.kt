package net.azarquiel.logintfg.screens.albaranes

import java.time.LocalDate

data class DiaOcupado(
    val fecha: LocalDate,
    val esOcupado: Boolean = false
)
