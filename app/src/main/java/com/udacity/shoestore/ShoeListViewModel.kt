package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    private val _isListEmpty = MutableLiveData<Boolean>()

    init {
        Timber.i("init ShoeList ViewModel")
        _shoeList.value = mutableListOf()
        _isListEmpty.value = true

    }

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    val isListEmpty: LiveData<Boolean>
        get() = _isListEmpty

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
        _isListEmpty.value = false
        Timber.i("new Shoe is added, list size is: " + _shoeList.value?.size)
    }
}