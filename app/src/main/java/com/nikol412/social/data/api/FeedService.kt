package com.nikol412.social.data.api

import com.nikol412.social.data.entities.LoginResponse
import com.nikol412.social.data.entities.PostDomain
import com.nikol412.social.data.entities.RegisterUserBody
import com.nikol412.social.data.entities.UserResponse
import com.nikol412.social.data.entities.requestBody.LoginUserBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FeedService {
    @GET("posts")
    suspend fun getPosts(): PostDomain

    @POST("auth/register")
    suspend fun signUp(@Body registerUserBody: RegisterUserBody): UserResponse

    @POST("auth/jwt/login")
    suspend fun login(@Body loginUserBody: LoginUserBody): LoginResponse
}//todo update signUp and login requests bodies and responses classes