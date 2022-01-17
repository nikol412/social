package com.nikol412.social.domain.net.models

data class RegisterUserBody(
    val email: String,
    val password: String,
    val is_active: Boolean,
    val is_superuser: Boolean,
    val is_verified: Boolean,
    val username: String,
    val password_confirm: String
)

data class LoginUserBody(
    val username: String,
    val password: String
)
