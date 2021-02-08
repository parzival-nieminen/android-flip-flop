package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

/**
 * Welcome fragment class
 */
class WelcomeFragment : Fragment() {

    lateinit var fragmentWelcomeBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        fragmentWelcomeBinding.welcomeButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_welcomeFragment_to_instructionFragment
            )
        )

        return fragmentWelcomeBinding.root
    }
}