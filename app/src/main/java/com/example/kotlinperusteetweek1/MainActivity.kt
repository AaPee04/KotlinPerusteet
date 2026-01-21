package com.example.kotlinperusteetweek1

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.util.Log
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import com.example.kotlinperusteetweek1.screens.HomeScreen
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kotlinperusteetweek1.ui.theme.Kotlinperusteetweek1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val tag = "MainActivity"
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme(){
                Surface() {
                    HomeScreen()
                }
            }
        }
    }
}