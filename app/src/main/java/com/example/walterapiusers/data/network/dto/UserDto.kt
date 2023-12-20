package com.example.walterapiusers.data.network.dto

data class UserDto(
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val email: String,
    val cellNumber: String,
)