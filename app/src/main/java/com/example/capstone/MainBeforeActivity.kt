package com.example.capstone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainBeforeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_before)

        val login_btn: Button = findViewById(R.id.main_login_btn)
        val intent = Intent(this, LoginActivity::class.java)

        login_btn.setOnClickListener{
            startActivity(intent)
            Log.d("성공","성공")
        }
    }
}

