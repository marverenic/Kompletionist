package com.marverenic.kompletionist.data

import com.marverenic.kompletionist.model.TodoList
import rx.Observable

class LocalTodoDataStore : TodoDataStore {

    var todoLists : List<TodoList> = ArrayList()

    override fun getTodoLists(): Observable<List<TodoList>> {
        return Observable.just(todoLists)
    }

}