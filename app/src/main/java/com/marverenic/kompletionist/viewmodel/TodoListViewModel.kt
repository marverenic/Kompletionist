package com.marverenic.kompletionist.viewmodel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.marverenic.kompletionist.R
import com.marverenic.kompletionist.databinding.ViewTaskBinding
import com.marverenic.kompletionist.model.Task
import com.marverenic.kompletionist.model.TodoList

class TodoListViewModel(context: Context) : BaseObservable() {

    val adapter = TaskAdapter()
    val layoutManager = LinearLayoutManager(context)

    fun setTodoList(list: TodoList) {
        adapter.apply{
            data = list.tasks
            notifyDataSetChanged()
        }
    }

}

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    var data : List<Task> = emptyList()

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent?.context)

        return TaskViewHolder(DataBindingUtil.inflate(inflater, R.layout.view_task, parent, false))
    }

}

class TaskViewHolder(val binding: ViewTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    val viewModel = TaskViewModel()

    init {
        binding.viewModel = viewModel
    }

    fun bind(task: Task) {
        viewModel.setTask(task)
        binding.executePendingBindings()
    }

}