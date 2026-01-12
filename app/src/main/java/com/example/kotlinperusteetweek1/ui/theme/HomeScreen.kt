package com.example.kotlinperusteetweek1.ui.theme

import java.time.LocalDate
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinperusteetweek1.domain.Task
import com.example.kotlinperusteetweek1.domain.mockTasks
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun HomeScreen(
    initialTasks: List<Task> = mockTasks
) {
    var tasks by remember { mutableStateOf(initialTasks) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Tehtävät",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // NAPIT
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(onClick = {
                tasks = addTask(
                    tasks,
                    )

            }) {
                Text("Lisää")
            }

            Button(onClick = {
                tasks = filterByDone(tasks, false)
            }) {
                Text("Avoimet")
            }

            Button(onClick = {
                tasks = filterByDone(tasks, true)
            }) {
                Text("Tehdyt")
            }

            Button(onClick = {
                tasks = sortByDueDate(tasks)
            }) {
                Text("Järjestä")
            }
        }

        tasks.forEach { task ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        tasks = toggleDone(tasks, task.id)
                    }
            ) {
                Column {
                    Text(text = task.title)
                    Text(
                        text = if (task.done) "Tehty" else "Tehtävä",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}
