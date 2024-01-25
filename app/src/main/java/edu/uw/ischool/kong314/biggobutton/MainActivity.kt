package edu.uw.ischool.kong314.biggobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.view.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        var count = 0
        button.text = getString(R.string.button_press_message, count)
        button.setOnClickListener {
            count++
            buttonPressed(count, it as Button)
        }
    }

    private fun buttonPressed(count: Int, button: Button) {
        val message = when (count) {
            1 -> getString(R.string.button_press_message_one)
            else -> getString(R.string.button_press_message, count)
        }
        button.text = message
        val rnd = Random()
        val color1 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        button.setBackgroundColor(color1)
        val color2 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        button.setTextColor(color2)
        val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
        if (count % 2 == 1) {
            button.startAnimation(animationRotate)
        } else {
            button.clearAnimation()
        }

    }
}