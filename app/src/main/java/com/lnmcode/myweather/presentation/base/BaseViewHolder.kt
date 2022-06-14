package com.lnmcode.myweather.presentation.base

import android.content.Context
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T: ViewDataBinding>(
    private val binding: T
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    /**
     * binds data to view holder class
     * */
    @Throws(Exception::class)
    abstract fun bindData(data: Any)
}