package com.example.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //retrofit object
        var retrofit = Retrofit.Builder()
            .baseUrl("http://ggwa.devcs.co.kr/") //스프링 서버주소
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //interface를 retrofit에 넣을 object
        var loginService = retrofit.create(LoginService::class.java)

        val intent = Intent(this, SignupActivity::class.java)
        val signup_btn: Button = findViewById(R.id.signup_btn)
        val login_btn: Button = findViewById(R.id.login_btn)
        val editText: EditText = findViewById(R.id.editText)
        val editText2: EditText = findViewById(R.id.editText2)


        signup_btn.setOnClickListener{
            startActivity(intent)
        }

        login_btn.setOnClickListener{
            var textId = editText.text.toString()
            var textPw = editText2.text.toString()

//            loginService.requestLogin(textId,textPw).enqueue(object: Callback<Login>{
            loginService.requestLogin(LoginRequestDto(textId, textPw)).enqueue(object: Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    var login: Login? = response.body() // code, msg

                    Log.d("headers", response.headers().toString())
                    Log.d("status", response.code().toString())
                    Log.d("??","$login");
                    var dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle("알람!")
                    dialog.setMessage("code = " + login?.data + " msg = " + login?.error)
                    dialog.show()
                }
                override fun onFailure(call: Call<Login>, t: Throwable) {
                    //웹 통신 실패 했을때 실행되는 코드
                    var dialog = AlertDialog.Builder(this@LoginActivity)
                    dialog.setTitle("에러!")
                    dialog.setMessage("통신에 실패하였습니다")
                    dialog.show()
                }
            })


        }
    }
}