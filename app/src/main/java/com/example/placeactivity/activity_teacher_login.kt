package com.example.placeactivity

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class activity_teacher_login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_login)

        val attendance = findViewById<LinearLayout>(R.id.menu_attendance)
        val hwork = findViewById<LinearLayout>(R.id.menu_homework)
        val result = findViewById<LinearLayout>(R.id.menu_result)
        val addAccount = findViewById<LinearLayout>(R.id.menu_add_account)

        // Attendance Page
        attendance.setOnClickListener {
            val intent = Intent(this, activity_attendance::class.java)
            startActivity(intent)
        }

        // Homework Page
        hwork.setOnClickListener {
            val intent = Intent(this, homework::class.java)
            startActivity(intent)
        }

        // Result Page
        result.setOnClickListener {
            val intent = Intent(this, Result::class.java)
            startActivity(intent)
        }

        // Add Student Account
        addAccount.setOnClickListener {
            val intent = Intent(this, StudentReg::class.java)
            startActivity(intent)
        }

    }
}