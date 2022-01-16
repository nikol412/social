package com.nikol412.social.ui.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nikol412.data.api.API
import com.nikol412.data.entities.PostItemDomain
import com.nikol412.social.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostsViewModel : BaseViewModel() {
    val api by lazy { API.apiService }

    val postsLD = MutableLiveData<List<PostItemDomain>>()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val posts = withContext(Dispatchers.IO) { api.getPosts() }
                postsLD.value = posts.items

            } catch (e: Exception) {
            }

        }
    }
}