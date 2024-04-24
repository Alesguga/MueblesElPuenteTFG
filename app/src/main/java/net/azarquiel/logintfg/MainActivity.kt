package net.azarquiel.logintfg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import net.azarquiel.logintfg.ui.theme.AppTypography
import net.azarquiel.logintfg.ui.theme.grisC
import net.azarquiel.logintfg.ui.theme.grisO
import net.azarquiel.logintfg.ui.theme.naranjaMEPC


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MueblesElPuenteAppTFGTheme {
                LoginContent()
            }
        }
    }
}
//Cuando llamo a la fuente personalizada el preview peta
@Composable
fun MueblesElPuenteAppTFGTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = AppTypography,
        content = content
    )
}
@Composable
fun LoginContent() {
    val context = LocalContext.current
    LoginScreen(onLogin = { email, password ->
        performLogin(email, password, context)
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
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.logomep),
            contentDescription = "Logo app",
            modifier = Modifier
                .size(200.dp)
                .padding(top = 50.dp)
            )
        Spacer(modifier = Modifier.height(90.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email")  },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),
            shape = RoundedCornerShape(20.dp),
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = password,
            onValueChange = { password = it },

            label = { Text("Contraseña") },
            visualTransformation = if (password.isNotEmpty()) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(autoCorrect = false),
            shape = RoundedCornerShape(20.dp),
            )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onLogin(email, password) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = grisC
            )
        ) {
            Text("Login", fontSize = 17.sp, color = naranjaMEPC)
        }

    }
}
// TODO: Llevar a una nueva pantalla donde muestre las dos opciones
fun performLogin(email: String, password: String, context: Context) {
    if (email.isNotBlank() && password.isNotBlank()) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Login completado!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login fallido: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    } else {
        Toast.makeText(context, "Porfavor introduce un gmail y una contraseña.", Toast.LENGTH_SHORT).show()
    }
}

//Para ver los cambios antes de ejecutar
@Preview(showBackground = true, name = "Login Screen Preview entera")
@Composable
fun PreviewLoginScreen() {
    MueblesElPuenteAppTFGTheme {
        LoginScreen(onLogin = { _, _ ->
        })
    }
}