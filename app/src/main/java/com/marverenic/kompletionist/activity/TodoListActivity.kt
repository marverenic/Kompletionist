package com.marverenic.kompletionist.activity

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.marverenic.kompletionist.KompletionistApplication
import com.marverenic.kompletionist.R
import com.marverenic.kompletionist.data.TodoDataStore
import com.marverenic.kompletionist.databinding.ActivityTodoListBinding
import com.marverenic.kompletionist.model.TodoList
import com.marverenic.kompletionist.viewmodel.TodoListViewModel
import javax.inject.Inject

class TodoListActivity : AppCompatActivity() {

    @Inject lateinit var todoStore: TodoDataStore
    lateinit var binding: ActivityTodoListBinding

    companion object {
        private val TODO_LIST_EXTRA = "list"

        fun newIntent(context: Context, todoList: TodoList): Intent {
            return Intent(context, TodoListActivity::class.java).apply {
                putExtra(TODO_LIST_EXTRA, todoList)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KompletionistApplication.component.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo_list)

        val viewModel = TodoListViewModel(this)
        val todoList = intent?.extras?.getParcelable<TodoList>(TODO_LIST_EXTRA)

        viewModel.setTodoList(todoList ?: throw IllegalArgumentException("Todo List expected"))
        binding.viewModel = viewModel
    }

}