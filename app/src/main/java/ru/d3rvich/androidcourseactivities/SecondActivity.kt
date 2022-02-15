package ru.d3rvich.androidcourseactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

private const val TAG = "SecondActivity"

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        logLifecycleState("created")

        textView = findViewById<TextView?>(R.id.text_view).apply {
            text = intent.getIntExtra(EXTRA_COUNT, -1).square().toString()
        }
    }

    override fun onStart() {
        super.onStart()
        logLifecycleState("started")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleState("resumed")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleState("paused")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleState("stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleState("destroyed")
    }

    private fun logLifecycleState(state: String) {
        Log.d(TAG, "Activity $state")
    }
}

private fun Int.square(): Int = this * this