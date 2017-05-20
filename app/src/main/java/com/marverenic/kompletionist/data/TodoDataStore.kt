package com.marverenic.kompletionist.data

import com.marverenic.kompletionist.model.TodoList
import io.reactivex.Observable

interface TodoDataStore {

    fun getTodoLists() : Observable<List<TodoList>>

}