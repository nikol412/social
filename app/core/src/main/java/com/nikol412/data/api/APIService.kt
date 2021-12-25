package com.nikol412.data.api

import com.nikol412.data.entities.PostDomain
import retrofit2.http.GET

interface APIService {
    @GET("posts")
    suspend fun getPosts(): List<PostDomain>
}