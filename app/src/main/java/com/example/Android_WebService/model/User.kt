package com.example.Android_WebService.model
/*
data class User (var username: String?, var pass: String?)  {
}*/

data class User  (
var email: String = "",
var password: String = "",
var username: String = "",
var name: String = "",
var token: String = "",
var type: String = "",
) {
    var error: String = ""
}
