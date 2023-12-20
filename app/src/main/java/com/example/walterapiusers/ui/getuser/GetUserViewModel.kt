package com.example.walterapiusers.ui.getuser

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GetUserViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(GetUserUiState())
    val uiState = _uiState.asStateFlow()

    fun onDeletePressed() {
        _uiState.update { it.copy(isDeleteButtonPressed = true) }
    }

    fun onDismiss() {
        _uiState.update { it.copy(isDeleteButtonPressed = false) }
    }

    fun delete() {

    }
}