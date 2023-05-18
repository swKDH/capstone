package com.example.capstone

import retrofit2.Call
import retrofit2.http.*


data class SignupRequestDto(val name: String)

interface SignupService{
    @Headers("Content-Type: application/json")
    @GET("/api/univ/list")
    fun requestSignup() : Call<Signup>
}