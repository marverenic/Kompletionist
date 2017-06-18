package com.marverenic.kompletionist.data

import com.marverenic.kompletionist.model.Task
import com.marverenic.kompletionist.model.TodoList
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class LocalTodoDataStore : TodoDataStore {

    val todoLists: MutableList<TodoList> = ArrayList()

    private fun now() = System.currentTimeMillis()
    private fun daysToMillis(days: Long) = TimeUnit.MILLISECONDS.convert(days, TimeUnit.DAYS)

    init {
        todoLists += TodoList("Important Stuff", listOf(
                Task(name = "Learn Kotlin", dueDate = now() + daysToMillis(10)),
                Task(name= "That thing with the stuff", dueDate = now() - daysToMillis(1), complete = true)
        ))
    }

    override fun getTodoLists(): Observable<List<TodoList>> {
        return Observable.just(todoLists)
    }

}