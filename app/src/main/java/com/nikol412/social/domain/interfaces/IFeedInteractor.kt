package com.nikol412.social.domain.interfaces

import com.nikol412.social.data.entities.PostDomain

interface IFeedInteractor {
    suspend fun getPosts(): List<PostItemUI>
}

data class PostItemUI(
    val id: Int,
    val title: String,
    val text: String,
)

fun PostDomain.toUIList(): List<PostItemUI> =
    this.items.map { item ->
        PostItemUI(item.id.hashCode(), item.userId.toString(), item.text)
    }