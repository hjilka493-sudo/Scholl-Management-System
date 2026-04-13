package com.example.placeactivity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class activity_login : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button

    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        dbHelper = DatabaseHelper(this)

        btnLogin.setOnClickListener {

            val email = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this,"Enter Email and Password",Toast.LENGTH_SHORT).show()

            } else {

                val isValid = dbHelper.checkLogin(email,password)

                if (isValid) {

                    Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, activity_student_login::class.java)
                    startActivity(intent)

                } else {

                    Toast.makeText(this,"Invalid Email or Password",Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}