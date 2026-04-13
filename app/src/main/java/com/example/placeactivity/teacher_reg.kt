package com.example.placeactivity

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class teacher_reg : AppCompatActivity() {

    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_reg)

        dbHelper = DatabaseHelper(this)

        val name = findViewById<EditText>(R.id.etTeacherName)
        val email = findViewById<EditText>(R.id.etTeacherEmail)
        val password = findViewById<EditText>(R.id.etPassword)

        val subjectSpinner = findViewById<Spinner>(R.id.spSubject)
        val sectionSpinner = findViewById<Spinner>(R.id.spSection)
        val languageSpinner = findViewById<Spinner>(R.id.spLanguage)

        val submitBtn = findViewById<Button>(R.id.btnSubmitTeacher)

        // Subject Spinner
        val subjectList = arrayOf(
            "Select Subject",
            "Gujarati",
            "Maths",
            "English",
            "Hindi",
            "Social Science",
            "Science",
            "Sanskrit"
        )

        subjectSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            subjectList
        )

        // Section Spinner
        val sectionList = arrayOf("Select Section", "A", "B")

        sectionSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            sectionList
        )

        // Language Spinner
        val languageList = arrayOf(
            "Select Language",
            "Gujarati",
            "English",
            "Hindi"
        )

        languageSpinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            languageList
        )

        submitBtn.setOnClickListener {

            val teacherName = name.text.toString().trim()
            val teacherEmail = email.text.toString().trim()
            val teacherPassword = password.text.toString().trim()

            val subject = subjectSpinner.selectedItem.toString()
            val section = sectionSpinner.selectedItem.toString()
            val language = languageSpinner.selectedItem.toString()

            // Regex Validation
            val nameRegex = Regex("^[A-Za-z]+\\s[A-Za-z]+$")
            val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
            val passwordRegex =
                Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{8,}$")

            if (teacherName.isEmpty() || teacherEmail.isEmpty() || teacherPassword.isEmpty()) {

                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()

            }

            else if (!teacherName.matches(nameRegex)) {

                Toast.makeText(this, "Enter First and Last Name properly", Toast.LENGTH_SHORT).show()

            }

            else if (!teacherEmail.matches(emailRegex)) {

                Toast.makeText(this, "Enter valid Email", Toast.LENGTH_SHORT).show()

            }

            else if (subject == "Select Subject") {

                Toast.makeText(this, "Please select Subject", Toast.LENGTH_SHORT).show()

            }

            else if (section == "Select Section") {

                Toast.makeText(this, "Please select Section", Toast.LENGTH_SHORT).show()

            }

            else if (language == "Select Language") {

                Toast.makeText(this, "Please select Language", Toast.LENGTH_SHORT).show()

            }

            else if (!teacherPassword.matches(passwordRegex)) {

                Toast.makeText(
                    this,
                    "Password must contain Upper, Lower, Number and Special character",
                    Toast.LENGTH_LONG
                ).show()

            }

            else {

                val isInserted = dbHelper.insertTeacher(
                    teacherName,
                    teacherEmail,
                    subject,
                    section,
                    language,
                    teacherPassword
                )

                if (isInserted) {

                    Toast.makeText(this, "Teacher Registration Successful", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, activity_teacher_login::class.java)
                    startActivity(intent)

                }

                else {

                    Toast.makeText(this, "Database Error", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}