package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
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

            list.forEach { shoeItem ->
                val shoeItemBinding: ShoeItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoe_item, container, false)
                shoeItemBinding.shoe = shoeItem
                fragmentShoeListBinding.shoeList.addView(shoeItemBinding.root)
            }

            if (viewModel.isListEmpty.value == false) {
                fragmentShoeListBinding.emptyListText.visibility = View.GONE
            }
        })

        fragmentShoeListBinding.showListAddButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        )

        setHasOptionsMenu(true)

        return fragmentShoeListBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_menu, menu)
    }

}