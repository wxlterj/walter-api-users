package com.example.walterapiusers.ui.form

data class UserFormUiState(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val isError: Boolean = false,
)