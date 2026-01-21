package com.example.kotlinperusteetweek1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlinperusteetweek1.domain.*

class TaskViewModel : ViewModel() {

    var tasks by mutableStateOf<List<Task>>(emptyList())
        private set

    init {
        tasks = mockData
    }

    fun addTask(task: Task) {
        tasks = addTask(tasks, task )
    }

    fun toggleDone(id: Int) {
        tasks = toggleDone (tasks, id)
    }

    fun removeTask(id: Int) {
        tasks = tasks.filterNot { it.id == id }
    }

    fun filterByDone(done: Boolean): List<Task> {
        return filterByDone(tasks, done)
    }

    fun sortByDueDate() {
        tasks = sortByDueDate(tasks)
    }
}