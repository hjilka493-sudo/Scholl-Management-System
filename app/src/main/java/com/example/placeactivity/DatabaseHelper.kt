package com.example.placeactivity

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "SchoolDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        // Teacher Table
        val createTeacherTable = """
            CREATE TABLE teacher(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            email TEXT,
            subject TEXT,
            section TEXT,
            language TEXT,
            password TEXT
            )
        """

        db.execSQL(createTeacherTable)

        // Student Table
        val createStudentTable = """
            CREATE TABLE student(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            email TEXT,
            class TEXT,
            section TEXT,
            rollno INTEGER,
            password TEXT
            )
        """

        db.execSQL(createStudentTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS teacher")
        db.execSQL("DROP TABLE IF EXISTS student")

        onCreate(db)
    }


    // ===============================
    // INSERT TEACHER
    // ===============================
    fun insertTeacher(
        name: String,
        email: String,
        subject: String,
        section: String,
        language: String,
        password: String
    ): Boolean {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put("name", name)
        values.put("email", email)
        values.put("subject", subject)
        values.put("section", section)
        values.put("language", language)
        values.put("password", password)

        val result = db.insert("teacher", null, values)

        return result != -1L
    }

    fun checkLogin(email: String, password: String): Boolean {

        val db = this.readableDatabase

        val query = "SELECT * FROM student WHERE email=? AND password=?"

        val cursor = db.rawQuery(query, arrayOf(email, password))

        val result = cursor.count > 0

        cursor.close()
        db.close()

        return result
    }


    fun checkTeacherLogin(email: String, password: String): Boolean {

        val db = this.readableDatabase

        val query = "SELECT * FROM teacher WHERE email=? AND password=?"

        val cursor = db.rawQuery(query, arrayOf(email, password))

        val result = cursor.count > 0

        cursor.close()
        db.close()

        return result
    }


    // ===============================
    // INSERT STUDENT
    // ===============================
    fun insertStudent(
        name: String,
        email: String,
        studentClass: String,
        section: String,
        rollNo: String,
        password: String
    ): Boolean {

        val db = this.writableDatabase
        val values = ContentValues()

        values.put("name", name)
        values.put("email", email)
        values.put("class", studentClass)
        values.put("section", section)
        values.put("rollno", rollNo)
        values.put("password", password)

        val result = db.insert("student", null, values)

        return result != -1L
    }

}