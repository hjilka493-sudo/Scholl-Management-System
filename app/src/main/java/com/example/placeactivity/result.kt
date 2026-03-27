package com.example.placeactivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Result : AppCompatActivity() {

    lateinit var btnPublishFirst: Button
    lateinit var btnPublishSecond: Button
    lateinit var bottomNav: BottomNavigationView
    lateinit var txtTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        btnPublishFirst = findViewById(R.id.btnPublishFirst)
        btnPublishSecond = findViewById(R.id.btnPublishSecond)
        bottomNav = findViewById(R.id.bottomNav)
        txtTitle = findViewById(R.id.txtTitle)

        btnPublishFirst.setOnClickListener {

            Toast.makeText(this, "First Terminal Result Published", Toast.LENGTH_SHORT).show()

        }

        btnPublishSecond.setOnClickListener {

            Toast.makeText(this, "Second Terminal Result Published", Toast.LENGTH_SHORT).show()

        }
    }
}