package com.example.mercadolivre.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseStatefulViewModel<S, A, E>(initialState: S) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S>
        get() = _state.asStateFlow()

    private val _events = Channel<E>()
    val events = _events.receiveAsFlow()

    abstract fun onViewAction(action: A)

    protected fun sendEvent(event: E) {
        viewModelScope.launch {
            _events.send(event)
        }
    }

    protected fun updateState(state: (S) -> S) {
        _state.update { state(it) }
    }

    protected fun setUIState(state: S) {
        _state.value = state
    }

    fun getUIState() = state.value
}