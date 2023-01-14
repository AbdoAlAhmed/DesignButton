package com.abdoalahmed.designbutton

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel():ViewModel() {
    private var _progress = MutableLiveData<Int>()
    val progress: LiveData<Int>
        get() = _progress
    init {
        _progress.value = 0
    }
    fun setProgress(progress: Int){
        _progress.value = progress
    }

}