package net.azarquiel.logintfg.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.azarquiel.logintfg.R
import net.azarquiel.logintfg.screens.login.performLogin
import net.azarquiel.logintfg.ui.theme.AppTypography
import net.azarquiel.logintfg.ui.theme.grisCC
import net.azarquiel.logintfg.ui.theme.grisO
import net.azarquiel.logintfg.ui.theme.naranjaMEP

@Composable
fun MueblesElPuenteAppTFGTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = AppTypography,
        content = content,
        colorScheme = MaterialTheme.colorScheme.copy(
            primaryContainer = grisCC
        )
    )
}

@Composable
fun LoginContent(navController: NavController) {
    val context = LocalContext.current
    LoginScreen(onLogin = { email, password ->
        performLogin(email, password, context, navController)
    })
}

//Diseño de la pagina del login
@Composable
fun LoginScreen(onLogin: (String, String) -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grisCC),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.logomep),
            contentDescription = "Logo app",
            modifier = Modifier
                .size(170.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Mail de empresa") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Email"
                )
            },
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
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled = false),
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Email"
                )
            },
            trailingIcon = {
                val image = if (passwordVisibility) Icons.Default.Clear else Icons.Default.Done
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = image, contentDescription = "Mostrar/Ocultar contraseña")
                }
            },
            label = { Text("Contraseña") },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrectEnabled = false),

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
            shape = RoundedCornerShape(10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { onLogin(email, password) },

            modifier = Modifier
                .width(250.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = (grisO),
                disabledContainerColor = Color.White
            ),

            shape = RoundedCornerShape(10.dp)

        ) {
            Text(
                "Login",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.White
                )
            )

        }

    }
}

@Preview(showBackground = true, name = "Login Screen Preview entera")
@Composable
fun PreviewLoginScreen() {
    MueblesElPuenteAppTFGTheme {
        LoginScreen(onLogin = { _, _ ->
        })
    }
}