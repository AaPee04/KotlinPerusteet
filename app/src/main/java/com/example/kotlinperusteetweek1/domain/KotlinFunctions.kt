package com.example.kotlinperusteetweek1.domain

fun addTask(list: List<Task>, newTask: Task): List<Task> {
    return list + newTask
}

fun toggleDone(list: List<Task>, id: Task): List<Task> {
}

fun sortByDueDate(list: List<Task>): List<Task> {
    return list.sortedBy { it.dueDate }
}