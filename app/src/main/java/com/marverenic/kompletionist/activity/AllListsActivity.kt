package com.marverenic.kompletionist.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.marverenic.kompletionist.KompletionistApplication
import com.marverenic.kompletionist.R
import com.marverenic.kompletionist.data.TodoDataStore
import com.marverenic.kompletionist.databinding.ActivityAllListsBinding
import com.marverenic.kompletionist.viewmodel.AllListsViewModel
import javax.inject.Inject

class AllListsActivity : AppCompatActivity() {

    @Inject lateinit var todoStore: TodoDataStore

    lateinit var binding: ActivityAllListsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KompletionistApplication.component.inject(this)

        val viewModel = AllListsViewModel(this)
        todoStore.getTodoLists().subscribe(viewModel::setData)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_all_lists)
        binding.viewModel = viewModel
    }
}
