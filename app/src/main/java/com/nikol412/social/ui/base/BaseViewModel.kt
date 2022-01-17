package com.nikol412.social.ui.base

import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {
    lateinit var navController: NavController

    fun navigateTo(@IdRes destination: Int) {
        if (this::navController.isInitialized.not()) return

        navController.navigate(destination)
    }
}