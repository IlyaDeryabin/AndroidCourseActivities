package ru.d3rvich.androidcourseactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

const val EXTRA_COUNT = "extra_count"

private const val TAG = "MainActivity"
private const val COUNT_KEY = "count_key"

class MainActivity : AppCompatActivity() {
    private lateinit var countTextView: TextView
    private lateinit var launcherButton: Button

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logLifecycleState("created")

        countTextView = findViewById(R.id.count_tv)
        launcherButton = findViewById(R.id.launch_btn)

        launcherButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_COUNT, count)
            }
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        logLifecycleState("started")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState called")
        count = savedInstanceState.getInt(COUNT_KEY) + 1
    }

    override fun onResume() {
        super.onResume()
        logLifecycleState("resumed")
        countTextView.text = count.toString()
    }

    override fun onPause() {
        super.onPause()
        logLifecycleState("paused")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleState("stopped")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(COUNT_KEY, count)
        Log.d(TAG, "onSaveInstanceState called")
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleState("destroyed")
    }

    private fun logLifecycleState(state: String) {
        Log.d(TAG, "Activity $state")
    }
}