package com.nikol412.social.data.entities

data class PostDomain(
    val items: List<PostItemDomain>,
    val total: Int,
    val page: Int,
    val size: Int
)

data class PostItemDomain(
    val text: String,
    val id: String,
    val userId: Long
)