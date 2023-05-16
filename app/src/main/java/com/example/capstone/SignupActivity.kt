package com.example.capstone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SignupActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signup_btn: Button = findViewById(R.id.signup_btn)
        val intent = Intent(this, EmailProfActivity::class.java)

        signup_btn.setOnClickListener{
            startActivity(intent)
            Log.d("성공","성공")
        }
    }
}