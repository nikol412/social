package com.nikol412.social.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.nikol412.data.api.API
import com.nikol412.domain.models.LoginUserBody
import com.nikol412.domain.models.RegisterUserBody
import com.nikol412.social.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpViewModel : BaseViewModel() {
    val login = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val email = MutableLiveData("")
    val api by lazy { API.apiService }

    fun onSignUpClick() {
        //todo check creds
        if (login.value.isNullOrBlank().not() && password.value.isNullOrBlank().not()) {
            registerUser(email.value!!, login.value!!, password.value!!)
        }
    }

    private fun registerUser(email: String, login: String, password: String) {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val userResponse = withContext(Dispatchers.IO) {
                    api.signUp(
                        RegisterUserBody(
                            email,
                            password,
                            is_active = true,
                            is_superuser = true,
                            is_verified = true,
                            username = login,
                            password_confirm = password
                        )
                    )
                }

                val loginResponse = withContext(Dispatchers.IO) {
                    api.login(
                        LoginUserBody(
                            userResponse.username,
                            password
                        )
                    )
                }

//                navigateTo(R.id.mai)
            } catch (e: Exception) {
            }
        }
    }
}