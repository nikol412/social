package com.nikol412.social.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.nikol412.social.databinding.MainFragmentBinding
import com.nikol412.social.ui.base.BaseFragment

class MainFragment : BaseFragment<MainFragmentBinding>(MainFragmentBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun subscribeToObservables() {
        viewModel.postsLD.observe(viewLifecycleOwner) {
            binding.message.text = it.firstOrNull()?.text
        }
    }

}