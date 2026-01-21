package com.example.kotlinperusteetweek1.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlinperusteetweek1.domain.*

class TaskViewModel : ViewModel() {

    var tasks by mutableStateOf<List<Task>>(mockData)
        private set

    init {
        tasks = mockData
    }

    fun addTask(task: Task) {
        tasks = tasks + task
    }

    fun toggleDone(id: Int) {
        tasks = tasks.map {
            if (it.id == id) it.copy(done = !it.done) else it
        }
    }

    fun removeTask(id: Int) {
        tasks = tasks.filterNot { it.id == id }
    }

    fun getTasksByDone(done: Boolean): List<Task> {
        return filterByDone(tasks, done)
    }

    fun sortTasksByDueDate() {
        tasks = sortByDueDate(tasks)
    }
}