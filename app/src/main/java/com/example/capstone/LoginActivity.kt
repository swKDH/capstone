package com.example.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val intent = Intent(this, SignupActivity::class.java)
        val signup_btn: Button = findViewById(R.id.signup_btn)

        signup_btn.setOnClickListener{
            startActivity(intent)
        }
    }
}