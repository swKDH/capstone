package com.example.capstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class EmailProfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_prof)

        val submit_btn : Button = findViewById(R.id.submit_btn)
        val intent = Intent(this, MainAfterActivity::class.java)


        submit_btn.setOnClickListener{
            startActivity(intent)
            Log.d("연결","굿")
        }
    }
}