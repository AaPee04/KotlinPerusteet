package com.example.kotlinperusteetweek1

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kotlinperusteetweek1.ui.theme.Kotlinperusteetweek1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val tag = "MainActivity"
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        enableEdgeToEdge()
        setContent {
            Kotlinperusteetweek1Theme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding( innerPadding)
                    )

                }
            }
        }
    }
    override fun onStart() {
        val tag = "MainActivity"
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        val tag = "MainActivity"
        super.onResume()
        Log.d(tag, "onResume")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


    HomeScreen()
}

@Composable
fun NameTextField(
    name: String,
    onNameChange: (String) -> Unit
) {
    OutlinedTextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text(text = "Nimi")}
    )
}
