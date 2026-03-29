package com.example.mad302_assignment1_ashish

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Screen that displays the full details of a clicked course.
 */
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Extract data passed from Intent
        val code = intent.getStringExtra("course_code")
        val name = intent.getStringExtra("course_name")
        val desc = intent.getStringExtra("course_desc")

        // Set text to UI
        findViewById<TextView>(R.id.detailCode).text = code
        findViewById<TextView>(R.id.detailName).text = name
        findViewById<TextView>(R.id.detailDesc).text = desc
    }
}