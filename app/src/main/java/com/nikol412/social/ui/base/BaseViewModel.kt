package com.nikol412.social.ui.base

import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

abstract class BaseViewModel : ViewModel() {
    lateinit var navController: NavController

    fun navigateTo(@IdRes destination: Int) {
        if (this::navController.isInitialized.not()) return

        navController.navigate(destination)
    }
}