package com.example.kotlinperusteetweek1

import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinperusteetweek1.domain.Task
import com.example.kotlinperusteetweek1.domain.addTask
import com.example.kotlinperusteetweek1.domain.filterByDone
import com.example.kotlinperusteetweek1.domain.mockData
import com.example.kotlinperusteetweek1.domain.removeTask
import com.example.kotlinperusteetweek1.domain.sortByDueDate
import com.example.kotlinperusteetweek1.domain.toggleDone

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    var name by remember { mutableStateOf("") }
    var tasklist by remember { mutableStateOf(mockData) }
    var showOnlyDone by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        NameTextField(name = name, onNameChange = { name = it })

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Tervehdys taas: $name")
        Spacer(modifier = Modifier.height(16.dp))

        val displayedTasks = if (showOnlyDone) filterByDone(tasklist, true) else tasklist

        displayedTasks.forEach { task ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    text = "${task.title} - Due ${task.dueDate}",
                    modifier = Modifier.weight(1f)
                )

                Button(
                    onClick = { tasklist = toggleDone(tasklist, task.id) },
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = if (task.done) "Tehty" else "Tekemätön",
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))

                Button(
                    onClick = { tasklist = removeTask(tasklist, task.id) },
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Poista",
                        fontSize = 12.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = {
                val newTask = Task(
                    id = tasklist.size + 1,
                    title = name,
                    description = "Description",
                    priority = 1,
                    dueDate = "2026.1.31",
                    done = false
                )
                tasklist = addTask(tasklist, newTask)
            }) {
                Text("Uusi task")
            }

            Button(onClick = { tasklist = sortByDueDate(tasklist) }) {
                Text("DueDate sort")
            }

            Button(
                onClick = { showOnlyDone = !showOnlyDone },
                modifier = Modifier.widthIn(min = 80.dp, max = 120.dp)
            ) {
                Text(
                    text = if (showOnlyDone) "Kaikki" else "Tehdyt",
                    maxLines = 1
                )
            }
        }
    }
}
