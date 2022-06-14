package com.lnmcode.myweather.presentation.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding>(
    @LayoutRes private val contentLayoutId: Int,
): AppCompatActivity() {

    private var _binding: T? = null

    protected val binding: T
        get() = checkNotNull(_binding) {
            "Activity $this binding cannot be accessed"
        }

    protected inline fun binding(block: T.() -> Unit): T {
        return binding.apply(block)
    }

    open val viewModel by viewModels<BaseViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, contentLayoutId) as T
        binding.run { lifecycleOwner = this@BaseActivity }
    }

}