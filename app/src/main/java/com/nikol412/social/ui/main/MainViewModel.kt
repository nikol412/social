package com.nikol412.social.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nikol412.data.api.API
import com.nikol412.data.entities.PostDomain
import com.nikol412.social.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : BaseViewModel() {
    val api by lazy { API.apiService }

    val postsLD = MutableLiveData<List<PostDomain>>()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            val posts = withContext(Dispatchers.IO) { api.getPosts() }

            postsLD.value = posts
        }
    }
}

