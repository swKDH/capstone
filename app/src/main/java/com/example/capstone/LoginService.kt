package com.example.capstone
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//input만들기
interface LoginService{
    @FormUrlEncoded //인코딩
    @POST()
    fun requestLogin(
        @Field("userid") userid : String,
        @Field("userpw") userpw : String
    //서버의 POST로 받는 이름이랑 같아야한다 태현이한테 묻기
    ) : Call<Login> //output 불러오기
}