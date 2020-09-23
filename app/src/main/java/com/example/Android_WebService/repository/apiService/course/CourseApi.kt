package com.example.Android_WebService.repository.apiService.course

import com.example.Android_WebService.model.Course
import retrofit2.Call
import retrofit2.http.*

interface CourseApi {

    @GET("{dbId}/courses")
    fun getCourses(@Path("dbId") user: String, @Header ("Authorization") header: String): Call<List<Course>>

    @POST("{dbId}/courses")
    fun addCourse(@Path("dbId") user: String, @Header ("Authorization") header: String): Call<Course>


}