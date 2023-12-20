package com.example.walterapiusers.data

import android.util.Log
import com.example.walterapiusers.data.network.UsersApiService
import com.example.walterapiusers.data.network.dto.UserDto
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val usersApiService: UsersApiService
) {
    suspend fun getUserById(userId: Int): Result<UserDto> {
        return try {
            Result.success(usersApiService.getUserById(userId))
        } catch (e: Exception) {
            Log.e("API ERROR", e.toString())
            Result.failure(e)
        }
    }

    suspend fun saveUser(user: UserDto): Result<UserDto> {
        return try {
            usersApiService.saveUser(user)
            Result.success(user)
        } catch (e: Exception) {
            Log.e("API ERROR", e.toString())
            Result.failure(e)
        }
    }
}