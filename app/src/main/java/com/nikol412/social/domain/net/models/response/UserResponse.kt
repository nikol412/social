package com.nikol412.social.domain.net.models.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    val id: String,
    val email: String,
    val is_active: Boolean,
    val is_superuser: Boolean,
    val is_verified: Boolean,
    val username: String,
    val created_at: String,
    val updated_at: String
)

data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String
)
