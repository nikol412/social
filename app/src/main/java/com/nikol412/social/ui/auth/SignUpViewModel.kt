package com.nikol412.social.ui.auth

import androidx.lifecycle.MutableLiveData
import com.nikol412.social.ui.base.BaseViewModel

class SignUpViewModel : BaseViewModel() {
    val login = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    fun onSignUpClick() {
        //todo check creds

    }
}