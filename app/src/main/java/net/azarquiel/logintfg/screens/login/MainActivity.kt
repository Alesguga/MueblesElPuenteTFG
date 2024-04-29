package net.azarquiel.logintfg.screens.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import android.content.Context
import android.widget.Toast
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import net.azarquiel.logintfg.navigation.AppNavigation
import net.azarquiel.logintfg.screens.login.components.LoginContent
import net.azarquiel.logintfg.screens.login.components.LoginScreen
import net.azarquiel.logintfg.screens.login.components.MueblesElPuenteAppTFGTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MueblesElPuenteAppTFGTheme {
                AppNavigation()
            }
        }
    }
}

fun performLogin(email: String, password: String, context: Context, navController: NavController) {
    if (email.isNotBlank() && password.isNotBlank()) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Login completado!", Toast.LENGTH_SHORT).show()
                    navController.navigate("home")
                } else {
                    Toast.makeText(context, "Login fallido: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    } else {
        Toast.makeText(context, "Por favor introduce un correo electrónico y una contraseña.", Toast.LENGTH_SHORT).show()
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