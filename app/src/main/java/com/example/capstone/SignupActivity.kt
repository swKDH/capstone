package com.example.capstone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class SignupActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var retrofit = Retrofit.Builder()
            .baseUrl("http://ggwa.devcs.co.kr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var signupService = retrofit.create(SignupService::class.java)

        val signup_btn: Button = findViewById(R.id.signup_btn)
        val intent = Intent(this, EmailProfActivity::class.java)
        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.school_item)
        val universities = mutableListOf<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, universities)
        autoCompleteTextView.setAdapter(adapter)
//        signupService.requestSignup(SignupRequestDto(name)).enqueue(object : Callback<Signup> {
        signupService.requestSignup().enqueue(object : Callback<Signup> {
            override fun onResponse(call: Call<Signup>, response: Response<Signup>) {
                var signup: Signup? = response.body()
                var dialog =  AlertDialog.Builder(this@SignupActivity)
                Log.d("aaa", signup?.data.toString())
                if (signup?.data == null){
                    dialog.setMessage("대학교 리스트 못받아옴")
                    dialog.show()
                }else{
                    universities.clear()
                    universities.addAll(signup.data)
                    adapter.notifyDataSetChanged()
                    var dialog =  AlertDialog.Builder(this@SignupActivity)
                    dialog.setMessage("대학교 리스트 받아오뮤ㅠ")
                    dialog.show()

                }
            }
            override fun onFailure(call: Call<Signup>, t: Throwable) {
                var dialog = AlertDialog.Builder(this@SignupActivity)
                dialog.setTitle("에러!")
                dialog.setMessage("통신에 실패하였습니다")
                dialog.show()
            }
        })
        signup_btn.setOnClickListener{
            startActivity(intent)
            Log.d("성공","성공")
        }
    }
}