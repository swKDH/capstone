package com.example.capstone
//서버에서 통신을 호출했을 때의 응답값 output 만들기
data class Login(

    var data : MutableMap<String, String>,
    var error: MutableList<String>
)