package com.example.placeactivity

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class activity_attendance : AppCompatActivity() {

    lateinit var classSpinner: Spinner
    lateinit var dateText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        classSpinner = findViewById(R.id.classSpinner)
        dateText = findViewById(R.id.dateText)

        val classList = arrayOf(
            "1 A","1 B",
            "2 A","2 B",
            "3 A","3 B",
            "4 A","4 B",
            "5 A","5 B",
            "6 A","6 B",
            "7 A","7 B",
            "8 A","8 B",
            "9 A","9 B",
            "10 A","10 B",
            "11 A","11 B",
            "12 A","12 B"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            classList
        )

        classSpinner.adapter = adapter

        dateText.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->

                    val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    dateText.text = date
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }
    }
}