package com.example.customdrawings

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

class DrawPath @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) { // extending with View class

    private var paint : Paint?=null //defining a paint variable
    private var mPath: Path?=null //motion path
    private var pathList = ArrayList<PaintPath>()//for redo
    private var undoPathList = ArrayList<PaintPath>()
    private var mX:Float?=null
    private var mY:Float?=null
    private var touchTolerance:Float?=4f  //defining touch tolerance

    init{  //initializing paint variable
        paint = Paint()
        paint!!.color= Color.BLUE //color
        paint!!.strokeWidth = 20f // width
        paint!!.style=Paint.Style.STROKE //geometry drawn will be stroked
        paint!!.isAntiAlias = true //smoother lines thanks to antialiasing
    }

    override fun onDraw(canvas: Canvas?) {
        if (pathList.size >0){    //
            for (path in pathList) {
                canvas!!.drawPath(path.path, paint!!)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val xAxis : Float=event!!.x  //defining x and y paths on their axis
        val yAxis : Float= event.y

        when ( event.action) {
            MotionEvent.ACTION_DOWN -> {  // for down action
                touchToStart(xAxis,yAxis)
                invalidate()
                /*if something changes and it needs to be reflected on screen,
                  invalidate() function need to be called. Therefore, I had to call invalidate
                  after all changes
                 */
            }
            MotionEvent.ACTION_MOVE -> {  // for move action
                touchToMove(xAxis, yAxis)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {  // for up action
                touchToUp()
                invalidate()
            }
        }
        invalidate()
        return true
    }
    private fun touchToStart(xAxis: Float, yAxis: Float) {
        mPath=Path()

        val paintPath = PaintPath(mPath!!)
        pathList.add(paintPath)  //adding path to path list
        mPath!!.reset()
        mPath!!.moveTo(xAxis,yAxis)
        mX=xAxis
        mY=yAxis
    }

    private fun touchToMove(xAxis: Float, yAxis: Float) {
        val dX:Float = abs(xAxis-mX!!)
        val dY:Float = abs(yAxis-mY!!)
        if (dX>= touchTolerance!! || dY>=touchTolerance!!){
            mPath!!.quadTo(mX!!, mY!!, (xAxis+mX!!) / 2, (yAxis + mY!!) / 2)
        }
        mX = xAxis
        mY = yAxis
    }

    private fun touchToUp() {
        mPath!!.lineTo(mX!!, mY!!)
    }

    fun setUndo(){
        val size = pathList.size
        if (pathList.size>0){
            undoPathList.add(pathList[size-1]) //adding the current path to " undone list " before removing the current path
            pathList.removeAt(size-1) //deleting the last path in "done list"
            invalidate()
        }
    }

    fun setRedo(){
        val size = undoPathList.size
        if (size>0){ // if users did not use undo button, they cannot use redo button
            pathList.add(undoPathList[size-1]) //adding the current path to " done list"
            undoPathList.removeAt(size-1) // deleting the last path in "undone list"
            invalidate()
        }

    }

}