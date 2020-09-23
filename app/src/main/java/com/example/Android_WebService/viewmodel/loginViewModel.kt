package com.example.Android_WebService.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.Android_WebService.model.User
import com.example.Android_WebService.repository.LoginRepository
import com.example.Android_WebService.repository.Repository
import com.example.Android_WebService.sharedPreference.Provider.Companion.getPassword
import com.example.Android_WebService.sharedPreference.Provider.Companion.getUserName

class loginViewModel: ViewModel() {

    var userLiveData = MutableLiveData<User>()
    val users = mutableListOf<User>()
    //val postsLiveData = MutableLiveData<List<Post>>()

    private val repository = LoginRepository()

    fun signIn(email: String, clave: String, usuario : String) =
        repository.signIn(User(email, clave, usuario, usuario,"",""))

    fun signUp(email: String, clave: String, usuario : String) =
        repository.signUp(User(email, clave, usuario, usuario,"",""))


    fun getUser() = userLiveData

    fun setuser(user: User){
        userLiveData.value = user
    }
/*
    fun signInSP(email: String, clave: String, usuario : String): Boolean {
        var user = User(email, clave, usuario, usuario,"","")
        userLiveData = signIn(user)
        users.clear()
        users.add(user)
        return getUsername().equals(usuario) && getUserPassword().equals(clave)
    }
    fun signUpSP(email: String, clave: String, usuario : String) {
        var user = User(email, clave, usuario, usuario,"","")
        userLiveData = signUp(user)
        users.clear()
        users.add(user)
        repository.addUser(user)
    }
*/
    fun getUsername() = repository.getUserName()
    fun getUserPassword() = repository.getPassword()
    fun setToken(token: String) = repository.setToken(token)
    /*
    private val users = MutableLiveData<List<User>>()
    private var userList = mutableListOf<User>()
    private val Repository = Repository()

    init {
        userList.add(User(Repository.getUserName(), Repository.getPassword()))
        users.value = userList
    }



    fun addUser(username: String, pass: String){
        val user: User = User (username,pass)
        Repository.addUser(user)
        userList.add(user)
        users.value = userList
    }

    fun getUsername() = Repository.getUserName()
    fun getUserPassword() = Repository.getPassword()
    fun getToken() = Repository.getToken()*/
}