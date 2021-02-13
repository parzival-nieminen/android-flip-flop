package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

/**
 * Shoe detail fragment class
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var fragmentShoeDetailBinding: FragmentShoeDetailBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        fragmentShoeDetailBinding.shoe = Shoe("",0.0, "", "")

        fragmentShoeDetailBinding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        )
        fragmentShoeDetailBinding.saveButton.setOnClickListener{
            viewModel.addShoe(fragmentShoeDetailBinding.shoe as Shoe)
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        return fragmentShoeDetailBinding.root
    }
}