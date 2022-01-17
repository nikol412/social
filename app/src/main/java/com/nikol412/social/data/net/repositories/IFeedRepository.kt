package com.nikol412.social.data.net.repositories

import com.nikol412.social.data.entities.PostDomain

interface IFeedRepository {
    suspend fun getPosts(): PostDomain
}