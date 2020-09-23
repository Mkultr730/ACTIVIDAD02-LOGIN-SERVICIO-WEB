package com.example.Android_WebService.repository

import com.example.Android_WebService.repository.apiService.course.CourseApiService

class CourseRepository {

    private val service = CourseApiService()

    fun getCourses(user: String, token: String) = service.getCourses(user,token)

    fun addCourse(user: String, token: String) = service.addCourse(user,token)

    fun getCourseData() = service.getCourseData()
}