package com.example.Android_WebService.sharedPreference

import android.content.Context
import android.content.SharedPreferences

class Provider () {
    companion object {
        lateinit var preference: SharedPreferences

        fun initialize(context: Context) {
            preference = context.getSharedPreferences("myAppPrefs", Context.MODE_PRIVATE)
        }

        fun setUserPass(userName: String?, pass: String?, token : String?) {
            preference.edit().putString("username", userName).apply()
            preference.edit().putString("pass", pass).apply()
            preference.edit().putString("token", token).apply()
        }

        fun setToken(token: String){
            preference.edit().putString("token", token).apply()
        }

        fun getUserName(): String? {
            return preference.getString("username", "nn")
        }

        fun getPassword(): String? {
            return preference.getString("pass", "nn")
        }

        fun getToken(): String? {
            return preference.getString("token", "nn")
        }
        
    }
}