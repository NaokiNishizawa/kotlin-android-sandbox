package com.example.mythirdapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    val data  = MutableLiveData<String>()
}