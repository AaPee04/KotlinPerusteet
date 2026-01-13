package com.example.kotlinperusteetweek1

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlinperusteetweek1.domain.Task
import com.example.kotlinperusteetweek1.domain.addTask
import com.example.kotlinperusteetweek1.domain.sortByDueDate
import com.example.kotlinperusteetweek1.domain.mockData
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
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

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

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    var name by remember { mutableStateOf("") }
    var tasklist by remember { mutableStateOf(mockData) }

    Column {
        NameTextField(
            name = name,
            onNameChange = { name = it }
        )

        Text(text = "Tervehdys taas: $name")

        Spacer(modifier = Modifier.height(16.dp))

        tasklist.forEach { task ->
            Text(text = "${task.id} - Title: ${task.title}")
        }

        Row {
            Button(
                onClick = {
                    val newTask = Task(
                        id = tasklist.size + 1,
                        title = name,
                        description = "Description",
                        priority = 1,
                        dueDate = "2023-10-31",
                        done = false
                    )

                    tasklist = addTask(tasklist, newTask)
                }
            ) {
                Text("Lisää uusi task")
            }

            Button(
                onClick = {
                    tasklist = tasklist.sortedBy { it.dueDate }

                    tasklist = sortByDueDate(tasklist)
                }


            ) {
                Text("Sort by DueDate")
            }
        }
    }
}