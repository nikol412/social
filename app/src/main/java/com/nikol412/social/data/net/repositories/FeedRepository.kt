package com.nikol412.social.data.net.repositories

import com.nikol412.social.data.api.FeedService
import com.nikol412.social.ui.posts.PostItemUI
import retrofit2.Retrofit

class FeedRepository(retrofit: Retrofit) : IFeedRepository {

    private val service by lazy { retrofit.create(FeedService::class.java) }

    override suspend fun getPosts(): List<PostItemUI> {
        return List(10) { i ->
            PostItemUI(
                i,
                "author $i",
                authorIconUrl = "https://www.aceshowbiz.com/images/photo/jim_carrey.jpg",
                "post by jim carrey about happiness",
                2319
            )
        }
    }
}