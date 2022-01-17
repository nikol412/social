package com.nikol412.social.di

import com.nikol412.social.domain.interactors.FeedInteractor
import com.nikol412.social.domain.interfaces.IFeedInteractor
import org.koin.core.module.Module
import org.koin.dsl.module


fun provideDomainModule() = module {
    provideInteractors()
}

fun Module.provideInteractors() {
    single<IFeedInteractor> { FeedInteractor(get()) }

}