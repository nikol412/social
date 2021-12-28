package com.nikol412.social.ui.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.nikol412.social.databinding.FragmentPostsBinding
import com.nikol412.social.ui.base.BaseFragment

class PostsFragment : BaseFragment<FragmentPostsBinding>(FragmentPostsBinding::inflate) {
    override val viewModel: PostsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun subscribeToObservables() {
        viewModel.postsLD.observe(viewLifecycleOwner) {
            binding.textView.text = it.firstOrNull()?.text
        }
    }
}