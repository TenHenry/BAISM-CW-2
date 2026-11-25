package com.tenhenry.baism51778

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PasswordCheckerScreen()
                }
            }
        }
    }
}

@Composable
fun PasswordCheckerScreen() {
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Sprawdź siłę hasła", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Hasło") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Rule("Co najmniej 8 znaków", PasswordValidator.hasMinLength(password))
        Rule("Wielka litera", PasswordValidator.hasUppercase(password))
        Rule("Mała litera", PasswordValidator.hasLowercase(password))
        Rule("Cyfra", PasswordValidator.hasDigit(password))
        Rule("Znak specjalny", PasswordValidator.hasSpecialChar(password))

        Text(
            text = if (PasswordValidator.isValid(password)) "Hasło jest silne" else "Hasło jest za słabe",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Composable
fun Rule(label: String, ok: Boolean) {
    Text((if (ok) "OK " else "ERROR ") + label)
}