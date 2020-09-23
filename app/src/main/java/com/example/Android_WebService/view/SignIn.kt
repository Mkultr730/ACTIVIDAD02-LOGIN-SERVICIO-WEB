package com.example.Android_WebService.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.Android_WebService.R
import com.example.Android_WebService.model.User
import com.example.Android_WebService.viewmodel.loginViewModel

class SignIn : Fragment() {
    lateinit var navController: NavController
    val loginViewModel: loginViewModel by viewModels()
    var theToken : String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        loginViewModel.userLiveData.observe(getViewLifecycleOwner(),  Observer { user ->
            Toast.makeText(context, "Token " + user.token, Toast.LENGTH_LONG).show()
        })

        view.findViewById<Button>(R.id.sign_in).setOnClickListener {
            //navController.navigate(R.id.action_signIn_to_home2)
            looged()
        }

        view.findViewById<Button>(R.id.sign_up).setOnClickListener {
            navController.navigate(R.id.action_signIn_to_signUp)
        }
    }

    private fun looged() {
        var user = requireView().findViewById<EditText>(R.id.username).text.toString()
        var pass = requireView().findViewById<EditText>(R.id.pass).text.toString()
        var email = requireView().findViewById<EditText>(R.id.email).text.toString()
/*
       if(loginViewModel.signInSP("user2@correo.com", pass, user)){
          loginViewModel.userLiveData.observe(getViewLifecycleOwner(), Observer { it ->
              Toast.makeText(context, "name 1 " + it.username, Toast.LENGTH_LONG).show()
              theToken = it.token
              loginViewModel.setToken(theToken)
              if (it.token != "") {
                  Toast.makeText(context, "Token " + it.token, Toast.LENGTH_LONG).show()
                  //loginViewModel.setuser(it)
                  navController.navigate(R.id.action_signIn_to_home2)
                  //courseViewModel.getCourses("elprofesor",theToken)
              } else {
                  Toast.makeText(context, "Token failure " + it.error, Toast.LENGTH_LONG)
                      .show()
              }
           })
*/
          // navController.navigate(R.id.action_signIn_to_home2)
           loginViewModel.signIn(email,pass,user).observe(getViewLifecycleOwner(), Observer { user: User ->

                //Log.d("MyOut", "Fragment  signIn " + user + " error " + user.error)
                theToken = user.token
                if (user.token != "") {
                    Toast.makeText(context, "Token " + user.token, Toast.LENGTH_LONG).show()
                    //navController.navigate(R.id.action_signIn_to_home2)
                    //courseViewModel.getCourses("elprofesor",theToken)
                } else {
                    Toast.makeText(context, "Token failure " + user.error, Toast.LENGTH_LONG)
                        .show()
                }
            })


      //requireView().findViewById<TextView>(R.id.textView2).text = loginViewModel.getUserPassword().toString()
    }
}