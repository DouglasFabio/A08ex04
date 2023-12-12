package com.example.a08ex04

import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("/users/")
    fun getUsers(): Call<Usuarios>

}