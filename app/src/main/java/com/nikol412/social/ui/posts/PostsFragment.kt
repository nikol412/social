package com.nikol412.social.ui.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.nikol412.social.databinding.FragmentPostsBinding
import com.nikol412.social.ui.base.BaseFragment
import com.nikol412.social.ui.posts.adapter.PostsAdapter

class PostsFragment : BaseFragment<FragmentPostsBinding>(FragmentPostsBinding::inflate) {
    override val viewModel: PostsViewModel by viewModels()

    private val postAdapter by lazy { PostsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.recyclerViewPosts.adapter = postAdapter
        binding.recyclerViewPosts.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.HORIZONTAL
            )
        )
    }

    override fun subscribeToObservables() {
        viewModel.postsLD.observe(viewLifecycleOwner) {
//            binding.textView.text = it.firstOrNull()?.text
            postAdapter.swapItems(it)
        }
    }
}