package com.example.kotlinperusteetweek1.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinperusteetweek1.domain.Task
import com.example.kotlinperusteetweek1.domain.mockTasks

@Composable
fun HomeScreen(
    tasks: List<Task> = mockTasks
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "My Tasks",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        tasks.forEach { task ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Column {
                    Text(text = task.title)
                    Text(
                        text = if (task.done) "Done" else "Not done",
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}