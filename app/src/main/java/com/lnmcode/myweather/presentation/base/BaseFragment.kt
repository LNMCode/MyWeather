package com.lnmcode.myweather.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>(
    @LayoutRes private val contentLayoutId: Int
) : Fragment() {

    private val bindingComponent = DataBindingUtil.getDefaultComponent()

    private var _binding: T? = null

    protected val binding: T
        get() = checkNotNull(_binding) {
            "Fragment $this binding cannot be accessed before onCreateView() or after onDestroyView()"
        }

    protected inline fun binding(block: T.() -> Unit): T {
        return binding.apply(block)
    }

    open val viewModel by viewModels<BaseViewModel>()

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater,
            contentLayoutId,
            container,
            false,
            bindingComponent
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpLayout()
        setUpEvents()
    }

    /**
     * set up layout binding with view
     */
    abstract fun setUpLayout()

    abstract fun setUpEvents()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}