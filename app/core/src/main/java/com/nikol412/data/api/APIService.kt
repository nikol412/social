package com.nikol412.data.api

import com.nikol412.data.entities.PostDomain
import com.nikol412.domain.models.LoginUserBody
import com.nikol412.domain.models.RegisterUserBody
import com.nikol412.domain.models.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {
    @GET("posts")
    suspend fun getPosts(): List<PostDomain>

    @POST("auth/register")
    suspend fun signUp(@Body registerUserBody: RegisterUserBody): UserResponse

    @POST("auth/jwt/login")
    suspend fun login(@Body loginUserBody: LoginUserBody): LoginUserBody
}