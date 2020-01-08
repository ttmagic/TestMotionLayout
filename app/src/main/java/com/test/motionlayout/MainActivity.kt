package com.test.motionlayout

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        motionLayout.post { motionLayout.progress = 1f }

        val btnSwitch = findViewById<Button>(R.id.btnSwitch)
        btnSwitch.setOnClickListener {
            motionLayout.post {
                motionLayout.setTransitionDuration(300)
                val progress = motionLayout.progress
                if (progress == 1f) {
                    motionLayout.transitionToStart()
                } else {
                    motionLayout.transitionToEnd()
                }
            }
        }
    }

}

