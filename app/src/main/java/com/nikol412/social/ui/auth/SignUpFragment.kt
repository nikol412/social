package com.nikol412.social.ui.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.nikol412.social.databinding.FragmentSignUpBinding
import com.nikol412.social.ui.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override val viewModel: SignUpViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun subscribeToObservables() {

    }
}