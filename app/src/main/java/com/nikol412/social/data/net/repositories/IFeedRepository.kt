package com.nikol412.social.data.net.repositories

import com.nikol412.social.data.entities.PostDomain
import com.nikol412.social.ui.posts.PostItemUI

interface IFeedRepository {
    suspend fun getPosts(): List<PostItemUI>
}