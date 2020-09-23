package com.example.Android_WebService.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.Android_WebService.R
import com.example.Android_WebService.viewmodel.CourseViewModel
import com.example.Android_WebService.viewmodel.loginViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlin.collections.List

class Home : Fragment() {
    lateinit var navController: NavController
    val loginViewModel: loginViewModel by viewModels()
    val courseViewModel: CourseViewModel by viewModels()
    private var adapter = Adapter(ArrayList())
    var token = ""
    var username = "h"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // requireView gets the root view for the fragment's layout
        // (the one returned by onCreateView).
        requireView().posts_recycler.adapter = adapter
        requireView().posts_recycler.layoutManager = LinearLayoutManager(requireContext())

        // get the live data and start observing
      /*  postViewModel.postsLiveData.observe(viewLifecycleOwner, Observer { it ->
            adapter.posts.clear()
            adapter.posts.addAll(it)
            adapter.notifyDataSetChanged()
        })*/

        //using the CourseViewModel
        courseViewModel.coursesLiveData.observe(getViewLifecycleOwner(), Observer { it ->
            adapter.courses.clear()
            adapter.courses.addAll(it)
            adapter.notifyDataSetChanged()
        })

        //Floating Buttom
        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {

            //val usuario : String = "elprofesor"
            //loginViewModel.getUsername()
            //loginViewModel.getToken()
            token = loginViewModel.users[0].token
            username = loginViewModel.users[0].name
            courseViewModel.addCourse(username,token)
            courseViewModel.getCourses(username,token)
            //postViewModel.getPost()
        }

        //Navegación de sign out
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.sign_out).setOnClickListener {
            navController.navigate(R.id.action_home2_to_signIn)
        }




    }
}

