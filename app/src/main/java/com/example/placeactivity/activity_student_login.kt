package com.example.placeactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class activity_student_login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_login)

        val  txt = findViewById<TextView>(R.id.tv_wel)

        val homeworkLayout = findViewById<LinearLayout>(R.id.homework_layout)
        val resultLayout = findViewById<LinearLayout>(R.id.result_layout)


        // Homework Click
        homeworkLayout.setOnClickListener {

            val intent = Intent(this, activity_homework_s::class.java)
            startActivity(intent)

        }

        // Result Click
        resultLayout.setOnClickListener {

            val intent = Intent(this, result_s::class.java)
            startActivity(intent)

        }


    }
}