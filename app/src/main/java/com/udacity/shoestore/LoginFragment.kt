package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * Login fragment class
 */
class LoginFragment : Fragment() {

    lateinit var fragmentLoginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        fragmentLoginBinding.loginButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            )
        )

        fragmentLoginBinding.createButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            )
        )

        return fragmentLoginBinding.root
    }
}