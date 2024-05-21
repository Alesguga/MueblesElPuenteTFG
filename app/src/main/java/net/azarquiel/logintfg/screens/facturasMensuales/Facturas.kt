package net.azarquiel.logintfg.screens.facturasMensuales

import android.widget.Space
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.google.firebase.database.*
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.screens.facturasMensuales.components.FacturaFB
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisC
import net.azarquiel.logintfg.ui.theme.grisO

@Composable
fun Facturas(navController: NavController){
    MueblesElPuenteAppTFGTheme {
        FacturasScreen(navController)
    }
}

@Composable
fun FacturaCard(factura: FacturaFB, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(3.dp, RoundedCornerShape(10.dp))
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = grisC
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Fecha: ${factura.fecha}", style = MaterialTheme.typography.bodyLarge, color = Color.White)
            Text(text = "Nombre: ${factura.nombreCompleto}", style = MaterialTheme.typography.bodyLarge, color = Color.White)
        }
    }
}

@Composable
fun FacturasScreen(navController: NavController) {
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
                facturas = nuevasFacturas
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
            Text(text = "Crear Nueva Factura", style = MaterialTheme.typography.bodyLarge, color = Color.White)
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(facturas) { factura ->
                FacturaCard(factura = factura) {
                    navController.navigate("factura/${factura.id}")
                }
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
