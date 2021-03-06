package com.marverenic.kompletionist.ui.lists

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.marverenic.kompletionist.KompletionistApplication
import com.marverenic.kompletionist.R
import com.marverenic.kompletionist.data.TodoDataStore
import com.marverenic.kompletionist.databinding.ActivityAllListsBinding
import com.marverenic.kompletionist.ui.BaseActivity
import javax.inject.Inject

class AllListsActivity : BaseActivity() {
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

    override fun canNavigateUp() = false

}
