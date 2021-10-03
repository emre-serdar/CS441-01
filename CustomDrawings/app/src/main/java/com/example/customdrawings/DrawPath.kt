package com.example.customdrawings

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawPath @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) { // extending with View class

    private var paint : Paint?=null
    private var path: Path?=null

    init{  //initializing paint variable
        paint = Paint()
        path = Path()
        paint!!.color= Color.BLUE
        paint!!.strokeWidth = 10f
        paint!!.style=Paint.Style.STROKE
        paint!!.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        canvas!!.drawPath(path!!, paint!!)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val xAxis : Float=event!!.x
        val yAxis : Float= event!!.y

        when ( event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                path!!.moveTo(xAxis, yAxis)
            }
            MotionEvent.ACTION_MOVE -> {
                path!!.lineTo(xAxis, yAxis)
            }
            MotionEvent.ACTION_UP -> {

            }
        }
        invalidate()
        return true
    }
}