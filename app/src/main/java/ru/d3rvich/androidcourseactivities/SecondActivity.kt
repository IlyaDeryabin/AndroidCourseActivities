package ru.d3rvich.androidcourseactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById<TextView?>(R.id.text_view).apply {
            text = intent.getIntExtra(EXTRA_COUNT, -1).square().toString()
        }
    }
}

private fun Int.square(): Int = this * this