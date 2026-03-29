package com.example.mad302_assignment1_ashish

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Course Code: MAD302-01
 * Lab Number: Assignment 1
 * Name: Ashish Prajapati
 * Student ID: A00194842
 * Date of Submission: March 29, 2026
 * Description: This is the main screen of the application. It initializes
 * a list of 6 courses and displays them using a RecyclerView.
 * It also handles the logic for opening DetailActivity when a course is tapped.
 */

/**
 * Main Activity that displays the list of 6 courses.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // List of 6 courses
        val courseList = listOf(
            Course("MAD302", "Android Development", "Building native apps using Kotlin."),
            Course("MAD402", "iOS Development", "Developing apps for iPhone using Swift."),
            Course("MAD307", "3D Graphics and Animation", "Intro to 3D modeling and animation."),
            Course("MAD317", "Mobile App Project Dev", "Managing mobile software projects."),
            Course("MAD411", "Mobile App Testing and QA", "Quality assurance for mobile apps."),
            Course("MAD407", "Mobile App Store Opt", "Marketing and store optimization.")
        )

        // Setup RecyclerVieW
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CourseAdapter(courseList) { selectedCourse ->
            // Pass data using Intent extras
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("course_code", selectedCourse.code)
                putExtra("course_name", selectedCourse.name)
                putExtra("course_desc", selectedCourse.description)
            }
            startActivity(intent)
        }
    }
}