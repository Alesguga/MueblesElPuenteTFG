package net.azarquiel.logintfg.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import net.azarquiel.logintfg.R
import net.azarquiel.logintfg.screens.login.performLogin
import net.azarquiel.logintfg.ui.theme.AppTypography
import net.azarquiel.logintfg.ui.theme.grisCC
import net.azarquiel.logintfg.ui.theme.grisO
import net.azarquiel.logintfg.ui.theme.naranjaMEPC

@Composable
fun MueblesElPuenteAppTFGTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = AppTypography,
        content = content
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(grisO)
            .padding(55.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.logomep),
            contentDescription = "Logo app",
            modifier = Modifier
                .size(160.dp)
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
                focusedContainerColor = grisCC,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                focusedLabelColor = naranjaMEPC,
                focusedLeadingIconColor = naranjaMEPC,
                focusedPlaceholderColor = naranjaMEPC,
                cursorColor = naranjaMEPC
            ),
            shape = RoundedCornerShape(10.dp),
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),
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
            label = { Text("Contraseña") },
            visualTransformation = if (password.isNotEmpty()) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),

            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = grisCC,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                focusedLabelColor = naranjaMEPC,
                focusedLeadingIconColor = naranjaMEPC,
                focusedPlaceholderColor = naranjaMEPC,
                cursorColor = naranjaMEPC
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
                containerColor = Color.White,
            ),

            shape = RoundedCornerShape(10.dp)

        ) {
            Text("Login",fontSize = 17.sp, color = Color.Black)
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