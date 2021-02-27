package com.zynastor.androidpaint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listener = View.OnClickListener {
            when (it) {
                decreaseValue -> MyView.radius -= 2
                increaseValue -> MyView.radius += 2
                setRed -> MyView.whatColor = 1
                setBlue -> MyView.whatColor = 2
                setYellow -> MyView.whatColor = 3
                setGreen -> MyView.whatColor = 4
                setBlack -> MyView.whatColor = 0
            }
        }
        increaseValue.setOnClickListener(listener)
        decreaseValue.setOnClickListener(listener)
        setRed.setOnClickListener(listener)
        setBlue.setOnClickListener(listener)
        setYellow.setOnClickListener(listener)
        setGreen.setOnClickListener(listener)
        setBlack.setOnClickListener(listener)
    }
}