package net.azarquiel.logintfg.screens.facturasMensuales

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.database.*
import net.azarquiel.logintfg.screens.facturasMensuales.components.FacturaCard
import net.azarquiel.logintfg.screens.facturasMensuales.components.FacturaFB
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisO
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun Facturas(navController: NavController){
    MueblesElPuenteAppTFGTheme {
        FacturasScreen(navController)
    }
}

@Composable
fun FacturasScreen(navController: NavController, context: android.content.Context = LocalContext.current) {
    val database = FirebaseDatabase.getInstance("https://loginmep-c4c56-default-rtdb.europe-west1.firebasedatabase.app/")
    val facturasRef = database.getReference("facturas")
    var facturas by remember { mutableStateOf<List<FacturaFB>>(emptyList()) }

    DisposableEffect(Unit) {
        val facturasListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val nuevasFacturas = mutableListOf<FacturaFB>()
                snapshot.children.forEach {
                    val factura = it.getValue(FacturaFB::class.java)?.copy(id = it.key ?: "")
                    if (factura != null) {
                        nuevasFacturas.add(factura)
                    }
                }
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                facturas = nuevasFacturas.sortedBy { dateFormat.parse(it.fecha) }
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }
        facturasRef.addValueEventListener(facturasListener)

        onDispose {
            facturasRef.removeEventListener(facturasListener)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.navigate("factura") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(0.dp, RoundedCornerShape(10.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = grisO
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Crear Nueva Factura",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White, fontSize = 18.sp
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(facturas) { factura ->
                FacturaCard(
                    factura = factura,
                    onClick = {
                        navController.navigate("factura/${factura.id}")
                    },
                    onDeleteClick = {
                        val facturasRef = database.getReference("facturas").child(factura.id)
                        facturasRef.removeValue().addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                facturas = facturas.filter { it.id != factura.id }
                                Toast.makeText(context, "Factura borrada con exito!", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Error al borrar la factura", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFacturasScreen() {
    MueblesElPuenteAppTFGTheme {
        FacturasScreen(NavController(context = LocalContext.current))
    }
}
