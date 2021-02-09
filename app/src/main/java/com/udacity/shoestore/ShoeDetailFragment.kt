package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

/**
 * Shoe detail fragment class
 */
class ShoeDetailFragment : Fragment() {

    lateinit var fragmentShoeDetailBinding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)


        fragmentShoeDetailBinding.cancelButton.setOnClickListener(
                Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        )

        return fragmentShoeDetailBinding.root
    }
}