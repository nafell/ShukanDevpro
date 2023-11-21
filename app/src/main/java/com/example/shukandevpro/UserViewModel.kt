package com.example.shukandevpro

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    private val _username = MutableLiveData<String>().apply{
        value = "user"
    }
    val username: MutableLiveData<String> = _username

    private val _gender = MutableLiveData<String>().apply{
        value = "male"
    }
    val gender: MutableLiveData<String> = _gender

    private val _age = MutableLiveData<Int>().apply {
        value = 20
    }
    val age: MutableLiveData<Int> = _age

    private val _height = MutableLiveData<Int>().apply {
        value = 170
    }
    val height: MutableLiveData<Int> = _height

    private val _weight = MutableLiveData<Int>().apply {
        value = 65
    }
    val weight: MutableLiveData<Int> = _weight

    fun applyUsername(username:String) {
        this.username.value = username
    }
}