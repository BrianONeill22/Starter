package com.base.starter.ui.screen.SecondScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SecondScreenViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(SecondScreenState()) // immutable state flow that only the view model can modify
    val uiState: StateFlow<SecondScreenState> =
        _uiState.asStateFlow() // public state flow that can be observed by the UI

    fun incrementCounter() {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(counter = currentState.counter + 1)
            }
        }
    }
}