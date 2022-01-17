package com.nikol412.social.ui.posts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nikol412.social.data.api.API
import com.nikol412.social.data.net.repositories.IFeedRepository
import com.nikol412.social.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

class PostsViewModel : BaseViewModel() {
    val api by lazy { API.apiService }
    val feedInteractor: IFeedRepository by inject()

    val postsLD = MutableLiveData<List<PostItemUI>>()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            val posts = withContext(Dispatchers.IO) { feedInteractor.getPosts() }
//            postsLD.value = posts

        }
    }
}

data class PostItemUI(
    val id: String
)