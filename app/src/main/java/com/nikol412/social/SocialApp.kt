package com.nikol412.social

import android.app.Application
import com.nikol412.social.di.provideDataModule
import com.nikol412.social.di.provideDomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class SocialApp : Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initDI()
    }

    private fun initDI() {
        GlobalContext.startKoin {
            androidLogger(Level.NONE)
            androidContext(this@SocialApp)
            val modules = listOf(
                provideDataModule(),
                provideDomainModule()
            )
            modules(modules)
        }
    }
}