package com.example.Android_WebService.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.Android_WebService.repository.apiService.login.LoginApiService
import com.example.Android_WebService.model.User
import com.example.Android_WebService.sharedPreference.Provider

class LoginRepository {

    private val sharedPreferences = Provider

    var userLiveData = MutableLiveData<User>()
    var tokenLiveData = MutableLiveData<String>()

    private val service = LoginApiService()

    fun signIn(user: User) = service.signIn(user)

    fun signUp(user: User) = service.signUp(user)

    fun getUser() = userLiveData as LiveData<User>
    fun getToken() = tokenLiveData as LiveData<String>

    fun addUser(user: User) {
        sharedPreferences.setUserPass(user.username, user.password, user.token)
    }

    fun getUserName() = sharedPreferences.getUserName()
    fun getPassword() = sharedPreferences.getPassword()
    fun setToken(tkn: String) = sharedPreferences.setToken(tkn)

}