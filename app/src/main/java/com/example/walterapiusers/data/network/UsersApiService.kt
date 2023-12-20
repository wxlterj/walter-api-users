package com.example.walterapiusers.data.network

import com.example.walterapiusers.data.network.dto.UserDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Body

interface UsersApiService {
    @GET("{userId}")
    suspend fun getUserById(@Path("userId") userId: Int): UserDto

    @POST("save")
    suspend fun saveUser(@Body userDto: UserDto)
}