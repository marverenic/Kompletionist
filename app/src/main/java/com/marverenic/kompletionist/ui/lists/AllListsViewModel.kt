package com.marverenic.kompletionist.ui.lists

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.marverenic.kompletionist.R
import com.marverenic.kompletionist.databinding.ViewTodoListBinding
import com.marverenic.kompletionist.model.TodoList

class AllListsViewModel(val context: Context) : BaseObservable() {

    private val adapter = AllListsAdapter()

    fun setData(todoLists: List<TodoList>) {
        adapter.apply {
            lists = todoLists
            notifyDataSetChanged()
        }
    }

    @Bindable
    fun getAdapter(): AllListsAdapter {
        return adapter
    }

    @Bindable
    fun getLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(context)

}

class AllListsAdapter : RecyclerView.Adapter<ListViewHolder>() {

    internal var lists = emptyList<TodoList>()

    override fun onBindViewHolder(viewHolder: ListViewHolder, index: Int) {
        viewHolder.onBind(lists[index])
    }

    override fun getItemCount() = lists.size

    override fun onCreateViewHolder(parent: ViewGroup?, itemViewType: Int): ListViewHolder {
        val binding: ViewTodoListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                R.layout.view_todo_list, parent, false)

        return ListViewHolder(binding)
    }

}

class ListViewHolder(val binding: ViewTodoListBinding) : RecyclerView.ViewHolder(binding.root) {

    internal val viewModel = ListViewModel(binding.root.context)

    init {
        binding.viewModel = viewModel
    }

    fun onBind(list: TodoList) {
        viewModel.setList(list)
        binding.executePendingBindings()
    }

}