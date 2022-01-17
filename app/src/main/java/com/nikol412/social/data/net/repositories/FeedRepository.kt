package com.nikol412.social.data.net.repositories

import com.nikol412.social.data.api.FeedService
import com.nikol412.social.data.entities.PostDomain
import retrofit2.Retrofit

class FeedRepository(retrofit: Retrofit) : IFeedRepository {

    private val service by lazy { retrofit.create(FeedService::class.java) }

    override suspend fun getPosts(): PostDomain = service.getPosts()
}