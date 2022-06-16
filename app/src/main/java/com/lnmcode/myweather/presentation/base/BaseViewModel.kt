package com.lnmcode.myweather.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _isLoading

    fun requestEvent(block: suspend () -> Unit) {
        _isLoading.value = true
        viewModelScope.launch { block() }
    }

    fun setLoading(boolean: Boolean) {
        _isLoading.value = boolean
    }

}