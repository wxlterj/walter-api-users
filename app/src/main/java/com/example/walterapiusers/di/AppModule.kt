package com.example.walterapiusers.di

import com.example.walterapiusers.data.UsersRepository
import com.example.walterapiusers.data.network.UsersApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserApi(): UsersApiService {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8010/walter-api/api/users/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build().create(UsersApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userApiService: UsersApiService): UsersRepository {
        return UsersRepository(userApiService)
    }
}