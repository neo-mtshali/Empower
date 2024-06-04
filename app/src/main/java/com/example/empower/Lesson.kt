package com.example.empower

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Lesson : AppCompatActivity() {

    private lateinit var coursesContainer: LinearLayout
    private val sixMonthCourses = listOf(
        Course("First Aid", "fa"),
        Course("Sewing", "sew"),
        Course("Landscaping", "land"),
        Course("Life Skills", "life")
    )
    private val sixWeekCourses = listOf(
        Course("Child Minding", "child"),
        Course("Cooking", "cook"),
        Course("Garden Maintenance", "garden")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnHmSc = findViewById<ImageButton>(R.id.btnHome)
        btnHmSc.setOnClickListener {
            val intent = Intent(this, HmSc::class.java)
            startActivity(intent)
        }

        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            val intent = Intent(this, Account::class.java)
            startActivity(intent)
        }

        coursesContainer = findViewById(R.id.coursesContainer)

        val courseTypeSpinner = findViewById<Spinner>(R.id.courseTypeSpinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.course_types,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        courseTypeSpinner.adapter = adapter

        courseTypeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    0 -> displayCourses(sixMonthCourses)
                    1 -> displayCourses(sixWeekCourses)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Initially display six-month courses
        displayCourses(sixMonthCourses)
    }

    private fun displayCourses(courses: List<Course>) {
        coursesContainer.removeAllViews()
        for (course in courses) {
            val cardView = layoutInflater.inflate(R.layout.course_card, coursesContainer, false) as CardView
            val textView = cardView.findViewById<TextView>(R.id.courseName)
            textView.text = course.name
            cardView.tag = course.tag
            cardView.setOnClickListener {
                val intent = when (course.tag) {
                    "fa" -> Intent(this, FirstAid::class.java)
                    "sew" -> Intent(this, Sewing::class.java)
                    "land" -> Intent(this, LandM::class.java)
                    "life" -> Intent(this, LifeSkills::class.java)
                    "child" -> Intent(this, ChildM::class.java)
                    "cook" -> Intent(this, Cook::class.java)
                    "garden" -> Intent(this, Garden::class.java)
                    else -> null
                }
                intent?.let { startActivity(it) }
            }
            coursesContainer.addView(cardView)
        }
    }
}

data class Course(val name: String, val tag: String)


