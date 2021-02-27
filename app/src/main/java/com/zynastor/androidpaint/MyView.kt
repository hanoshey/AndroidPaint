package com.zynastor.androidpaint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

private const val TAG = "MyView"

class MyView(context: Context?, attr: AttributeSet) : View(context) {
    var p1 = Paint()
    var p2 = Paint()
    var p3 = Paint()
    var p4 = Paint()
    var p5 = Paint()
    var myData_x = IntArray(30000)
    var myData_y = IntArray(30000)
    var myData_color = IntArray(30000)
    var radiusArray = IntArray(30000)

    companion object {
        var radius = 15
        var whatColor = 0
    }

    var dataNumber = 0
    var mx = 0
    var my = 0

    init {
        myData_x[0] = 0
        myData_y[0] = 0
        myData_color[0] = 0
        radiusArray[0] = 15
        p1.color = Color.BLACK
        p2.color = Color.RED
        p3.color = Color.BLUE
        p4.color = Color.YELLOW
        p5.color = Color.GREEN
    }

    override fun onDraw(canvas: Canvas?) {
        for (i in 1..dataNumber) {
            when (myData_color[i]) {
                0 -> canvas!!.drawCircle(
                    myData_x[i].toFloat(), myData_y[i].toFloat(), radiusArray[i].toFloat(), p1
                )
                1 -> canvas!!.drawCircle(
                    myData_x[i].toFloat(), myData_y[i].toFloat(), radiusArray[i].toFloat(), p2
                )
                2 -> canvas!!.drawCircle(
                    myData_x[i].toFloat(), myData_y[i].toFloat(), radiusArray[i].toFloat(), p3
                )
                3 -> canvas!!.drawCircle(
                    myData_x[i].toFloat(), myData_y[i].toFloat(), radiusArray[i].toFloat(), p4
                )
                4 -> canvas!!.drawCircle(
                    myData_x[i].toFloat(), myData_y[i].toFloat(), radiusArray[i].toFloat(), p5
                )
            }
        }
        invalidate()
    }

    private fun saveData() {
        myData_x[dataNumber] = mx
        myData_y[dataNumber] = my
        myData_color[dataNumber] = whatColor
        radiusArray[dataNumber] = radius
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        mx = event.x.toInt()
        my = event.y.toInt()
        dataNumber += 1
        saveData()
        return true
    }
}