package com.example.kotlinperusteetweek1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kotlinperusteetweek1.ui.theme.Kotlinperusteetweek1Theme
import com.example.kotlinperusteetweek1.ui.theme.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Kotlinperusteetweek1Theme {
                HomeScreen()
            }
        }
    }
}
