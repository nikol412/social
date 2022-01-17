package com.nikol412.social.domain.net.repositories

import com.nikol412.social.data.entities.PostDomain

interface IFeedRepository {
    suspend fun getPosts(): PostDomain
}