package net.azarquiel.logintfg.screens.facturasMensuales

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.database.*
import net.azarquiel.logintfg.screens.facturasMensuales.components.FacturaFB
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
@Composable
fun Facturas(){
    MueblesElPuenteAppTFGTheme {
        FacturasScreen()
    }
}
@Composable
fun FacturaCard(factura: FacturaFB) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {  }
            .shadow(5.dp, RoundedCornerShape(10.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Fecha: ${factura.fecha}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Nombre: ${factura.nombreCompleto}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun FacturasScreen() {
    val database = FirebaseDatabase.getInstance("https://loginmep-c4c56-default-rtdb.europe-west1.firebasedatabase.app/")
    val facturasRef = database.getReference("facturas")
    var facturas by remember { mutableStateOf<List<FacturaFB>>(emptyList()) }

    DisposableEffect(Unit) {
    val facturasListener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val nuevasFacturas = mutableListOf<FacturaFB>()
            snapshot.children.forEach {
                val factura = it.getValue(FacturaFB::class.java)
                if (factura != null) {
                    nuevasFacturas.add(factura)
                }
            }
            facturas = nuevasFacturas
        }

        override fun onCancelled(error: DatabaseError) {
            // Manejar error de base de datos
        }
    }
    facturasRef.addValueEventListener(facturasListener)

    onDispose {
        facturasRef.removeEventListener(facturasListener)
    }
}

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(facturas) { factura ->
            FacturaCard(factura = factura)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFacturasScreen() {
    MueblesElPuenteAppTFGTheme {
        FacturasScreen()
    }
}
