package com.example.walterapiusers.ui.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walterapiusers.data.UsersRepository
import com.example.walterapiusers.data.network.dto.UserDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserFormViewModel @Inject constructor(
    private val usersRepository: UsersRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(UserFormUiState())
    val uiState = _uiState.asStateFlow()

    fun onFirstNameChange(firstName: String) {
        _uiState.update {
            it.copy(firstName = firstName)
        }
    }

    fun onLastNameChange(lastName: String) {
        _uiState.update {
            it.copy(lastName = lastName)
        }
    }
    fun onEmailChange(email: String) {
        _uiState.update {
            it.copy(email = email)
        }
    }
    fun onPhoneNumberChange(phoneNumber: String) {
        _uiState.update {
            it.copy(phoneNumber = phoneNumber)
        }
    }

    fun getUserById() {
        viewModelScope.launch {
            usersRepository.getUserById(_uiState.value.phoneNumber.toInt()).onSuccess { user ->
                _uiState.update { it.copy(firstName = user.firstName) }
            }.onFailure {
                _uiState.update { it.copy(isError = true) }
            }
        }
    }

    fun saveUser() {
        val user = UserDto(
            firstName = _uiState.value.firstName,
            lastName = _uiState.value.lastName,
            email = _uiState.value.email,
            cellNumber = _uiState.value.phoneNumber
        )
        viewModelScope.launch {
            usersRepository.saveUser(user).onFailure {
                _uiState.update { it.copy(isError = true) }
            }
        }
    }

    fun onDismissRequest() {
        _uiState.update { it.copy(isError = false) }
    }
}