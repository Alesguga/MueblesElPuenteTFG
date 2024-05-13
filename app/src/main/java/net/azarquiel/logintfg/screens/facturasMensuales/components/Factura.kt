
package net.azarquiel.logintfg.screens.facturasMensuales.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import net.azarquiel.logintfg.screens.commoncomponents.NavPill
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme
import net.azarquiel.logintfg.ui.theme.naranjaMEP
import java.time.LocalDate

@Composable
fun factura(){
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
    NavPill("Factura")
    Column(modifier = Modifier.padding(10.dp,80.dp,8.dp,10.dp)) {
        TextField(
            value = fecha,
            onValueChange = { fecha = it },
            label = { Text("Fecha") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)

        )
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            TextField(
                value = nombreCompleto,
                onValueChange = { nombreCompleto = it },
                label = { Text("Nombre Completo")},
                modifier = Modifier
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
                keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)

            )
            Spacer(modifier = Modifier.width(8.dp))
            TextField(
                value = dni,
                onValueChange = { dni = it },
                label = { Text("DNI") },
                modifier = Modifier
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
                keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = calle, 
            onValueChange = { calle = it },
            label = { Text("Calle") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = codigoP, 
            onValueChange = { codigoP = it },
            label = { Text("Código Postal") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = cuerpo, 
            onValueChange = { cuerpo = it },
            label = { Text("Cuerpo") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = localidad, 
            onValueChange = { localidad = it },
            label = { Text("Localidad") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = numero, 
            onValueChange = { numero = it },
            label = { Text("Número") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = piso, 
            onValueChange = { piso = it },
            label = { Text("Piso") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = portal, 
            onValueChange = { portal = it },
            label = { Text("Portal") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = precio, 
            onValueChange = { precio = it },
            label = { Text("Precio") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = telefono, 
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = total, 
            onValueChange = { total = it },
            label = { Text("Total") },
            modifier = Modifier
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled  = false)
        )
    }
}
@Preview (showBackground = true)
@Composable
fun PreviewFacturaForm() {
    MueblesElPuenteAppTFGTheme {
        factura()
    }
}
