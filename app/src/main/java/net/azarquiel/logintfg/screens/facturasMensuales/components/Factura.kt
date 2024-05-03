package net.azarquiel.logintfg.screens.facturasMensuales.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import java.time.LocalDate

@Composable
fun FacturaForm(navController: NavController, db: FirebaseFirestore) {
    val fecha by remember { mutableStateOf(LocalDate.now()) }
    var cliente by remember { mutableStateOf("") }
    val dni by remember { mutableStateOf("") }
    val direccion by remember { mutableStateOf("") }
    val localidad by remember { mutableStateOf("") }
    val telefono by remember { mutableStateOf("") }
    val conceptos by remember { mutableStateOf(listOf<String>()) }
    val total by remember { mutableStateOf("") }
    val observaciones by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = cliente,
            onValueChange = { cliente = it },
            label = { Text("Cliente") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Repite los TextFields para dni, dirección, localidad, teléfono, etc.
        Button(
            onClick = {
                val factura = hashMapOf(
                    "fecha" to Timestamp.now(), // Convertir LocalDate a Timestamp si es necesario
                    "cliente" to cliente,
                    "dni" to dni,
                    "direccion" to direccion,
                    "localidad" to localidad,
                    "telefono" to telefono,
                    "conceptos" to conceptos,
                    "total" to total,
                    "observaciones" to observaciones
                )
                db.collection("facturas").add(factura)
                    .addOnSuccessListener { navController.popBackStack() }
                    .addOnFailureListener { e -> /* Manejar errores aquí */ }
            }
        ) {
            Text("Guardar Factura")
        }
    }
}
@Preview
@Composable
fun PreviewFacturaForm() {
    MueblesElPuenteAppTFGTheme {
        FacturaForm(navController = NavController(LocalContext.current), db = FirebaseFirestore.getInstance())
    }
}
