package com.example.capstone
import retrofit2.Call
import retrofit2.http.*

//input만들기
data class LoginRequestDto(val email: String, val password: String)

interface LoginService{
//    @FormUrlEncoded //인코딩
    @Headers("Content-Type: application/json")
    @POST("/api/member/signin")
    fun requestLogin(
        @Body loginRequestDto: LoginRequestDto
//        @Field("email") email : String,
//        @Field("password") password : String
    //서버의 POST로 받는 이름이랑 같아야한다 태현이한테 묻기
    ) : Call<Login> //output 불러오기
}