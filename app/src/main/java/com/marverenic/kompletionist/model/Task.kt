package com.marverenic.kompletionist.model

data class Task(val complete: Boolean = false,
                val name: String,
                val dueDate: Long,
                val subTasks: List<SubTask> = emptyList())