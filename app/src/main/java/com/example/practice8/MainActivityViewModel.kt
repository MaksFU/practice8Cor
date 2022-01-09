package com.example.practice8

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel  : ViewModel() {
//    val editT: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val str : MutableLiveData<String> by lazy { MutableLiveData<String>() }

}