package com.nikol412.social.domain.interactors

import com.nikol412.social.domain.interfaces.IFeedInteractor
import com.nikol412.social.domain.interfaces.PostItemUI
import com.nikol412.social.domain.interfaces.toUIList
import com.nikol412.social.domain.net.repositories.IFeedRepository

class FeedInteractor(private val netRepository: IFeedRepository) : IFeedInteractor {
    override suspend fun getPosts(): List<PostItemUI> = netRepository.getPosts().toUIList()
}