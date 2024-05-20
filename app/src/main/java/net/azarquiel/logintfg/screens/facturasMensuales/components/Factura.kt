package net.azarquiel.logintfg.screens.facturasMensuales.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.database.FirebaseDatabase
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.grisC
import net.azarquiel.logintfg.ui.theme.naranjaMEP

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier
            .fillMaxWidth()
            .shadow(7.dp, RoundedCornerShape(10.dp)),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            unfocusedTextColor = Color.Black,
            focusedTextColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = naranjaMEP,
            focusedLeadingIconColor = naranjaMEP,
            focusedPlaceholderColor = naranjaMEP,
            cursorColor = naranjaMEP
        ),
        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled = false)
    )
}

@Composable
fun factura(facturaId: String?) {
    var calle by remember { mutableStateOf("") }
    var codigoP by remember { mutableStateOf("") }
    var cuerpo by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }
    var localidad by remember { mutableStateOf("") }
    var nombreCompleto by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var piso by remember { mutableStateOf("") }
    var portal by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }

    val database = FirebaseDatabase.getInstance("https://loginmep-c4c56-default-rtdb.europe-west1.firebasedatabase.app/")
    val facturasRef = if (facturaId != null) {
        database.getReference("facturas").child(facturaId)
    } else {
        database.getReference("facturas").push()
    }

    LaunchedEffect(facturaId) {
        facturaId?.let {
            facturasRef.get().addOnSuccessListener { snapshot ->
                val factura = snapshot.getValue(FacturaFB::class.java)
                if (factura != null) {
                    calle = factura.calle
                    codigoP = factura.codigoP
                    cuerpo = factura.cuerpo
                    dni = factura.dni
                    fecha = factura.fecha
                    localidad = factura.localidad
                    nombreCompleto = factura.nombreCompleto
                    numero = factura.numero
                    piso = factura.piso
                    portal = factura.portal
                    precio = factura.precio
                    telefono = factura.telefono
                    total = factura.total
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        NavPill("Factura")
        CustomTextField(value = fecha, onValueChange = { fecha = it }, label = "Fecha")
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            CustomTextField(value = nombreCompleto, onValueChange = { nombreCompleto = it }, label = "Nombre Completo", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            CustomTextField(value = dni, onValueChange = { dni = it }, label = "DNI", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(value = calle, onValueChange = { calle = it }, label = "Calle")
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(value = codigoP, onValueChange = { codigoP = it }, label = "Código Postal")
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(value = cuerpo, onValueChange = { cuerpo = it }, label = "Cuerpo")
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(value = localidad, onValueChange = { localidad = it }, label = "Localidad")
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(value = numero, onValueChange = { numero = it }, label = "Número")
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            CustomTextField(value = piso, onValueChange = { piso = it }, label = "Piso", modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(8.dp))
            CustomTextField(value = portal, onValueChange = { portal = it }, label = "Portal", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(value = precio, onValueChange = { precio = it }, label = "Precio")
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(value = telefono, onValueChange = { telefono = it }, label = "Teléfono")
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(value = total, onValueChange = { total = it }, label = "Total")
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val factura = FacturaFB(
                id = facturaId ?: facturasRef.key ?: "",
                calle = calle,
                codigoP = codigoP,
                cuerpo = cuerpo,
                dni = dni,
                fecha = fecha,
                localidad = localidad,
                nombreCompleto = nombreCompleto,
                numero = numero,
                piso = piso,
                portal = portal,
                precio = precio,
                telefono = telefono,
                total = total
            )
            facturasRef.setValue(factura)
        }, modifier = Modifier
            .fillMaxWidth()
            .shadow(12.dp, shape = RoundedCornerShape(10.dp))
            .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = grisC,
                disabledContainerColor = Color.White
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("Enviar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFacturaForm() {
    MueblesElPuenteAppTFGTheme {
        factura(facturaId = "sampleId")
    }
}
