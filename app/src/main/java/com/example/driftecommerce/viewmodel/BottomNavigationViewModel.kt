package com.example.driftecommerce.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BottomNavigationViewModel : ViewModel() {
    private val _selectedItemId = MutableLiveData<Int>()
    val selectedItemId: LiveData<Int> = _selectedItemId

    fun setSelectedItemId(itemId: Int) {
        _selectedItemId.value = itemId
    }
}