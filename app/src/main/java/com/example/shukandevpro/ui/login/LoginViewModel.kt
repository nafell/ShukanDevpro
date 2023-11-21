package com.example.shukandevpro.ui.login

import android.app.Application
import android.os.Handler
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class LoginViewModel(app: Application) : AndroidViewModel(app) {
    private val applicationContext = getApplication<Application>().applicationContext

    private val _username = MutableLiveData<String>().apply {
        value = "user"
    }
    val username: MutableLiveData<String> = _username

    private val _password = MutableLiveData<String>().apply {
        value = ""
    }
    val password: MutableLiveData<String> = _password

    private val _loading = MutableLiveData<Int>().apply {
        value = View.INVISIBLE
    }
    val loading: MutableLiveData<Int> = _loading

    private val _loginSuccess = MutableLiveData<Boolean>().apply {
        value = false
    }
    val loginSuccess: MutableLiveData<Boolean> = _loginSuccess

    fun login() {
        loading.value = View.VISIBLE

        val handler = Handler()
        val r = Runnable {
            loginSuccess.value = true
        }
        handler.postDelayed(r, 2000)

    }


}