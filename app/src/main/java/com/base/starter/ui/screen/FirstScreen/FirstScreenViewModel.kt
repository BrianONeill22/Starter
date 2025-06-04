package com.base.starter.ui.screen.FirstScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FirstScreenViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(FirstScreenState()) // immutable state flow that only the view model can modify
    val uiState: StateFlow<FirstScreenState> =
        _uiState.asStateFlow() // public state flow that can be observed by the UI

    fun updateMessage(newMessage: String) {
        viewModelScope.launch {
            _uiState.update { currentState ->
                currentState.copy(message = newMessage)
            }
        }
    }
}