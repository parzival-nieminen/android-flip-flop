package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import timber.log.Timber

/**
 * Shoe list fragment class
 */
class ShoeListFragment : Fragment() {

    private lateinit var fragmentShoeListBinding: FragmentShoeListBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        viewModel.shoeList.observe(this.viewLifecycleOwner, { list ->
            Timber.i("Change in shoeList")
            fragmentShoeListBinding.emptyListText.text = list.toString()
        })

        fragmentShoeListBinding.showListAddButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        )

        return fragmentShoeListBinding.root
    }
}