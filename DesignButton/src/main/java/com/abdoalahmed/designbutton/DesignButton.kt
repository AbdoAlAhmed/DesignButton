package com.abdoalahmed.designbutton

import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import kotlin.properties.Delegates

@SuppressLint("Recycle")
class DesignButton @JvmOverloads constructor(
    context: Context, attr: AttributeSet? = null, defStyle: Int = 0
) : View(context, attr, defStyle) {
    private var widthSize = 0
    private var heightSize = 0
    private var progress = 0
    private var text = "Download"
    private var textColor = 0
    private var _backgroundColor = 0
    private var backgroundProgressColor = 0
    private var circleColor = 0
    private var circleProgressColor = 0
    private var animate = ValueAnimator()

    private var buttonState: ButtonState by Delegates.observable<ButtonState>(ButtonState.Completed) { k, _, new ->
        when (new) {
            ButtonState.Completed -> {
                text = "Download"
                progress = 0
                animate.cancel()
                invalidate()
            }
            ButtonState.Clicked -> {
                animationButton()

            }
            else -> {

            }
        }
        invalidate()

    }

    private fun animationButton() {

        animate = ValueAnimator.ofInt(0, 100)
        animate.duration = 3000
        animate.interpolator = LinearInterpolator()
        animate.addUpdateListener {
            progress = it.animatedValue as Int
            invalidate()
        }
        animate.start()

    }


    private var paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL_AND_STROKE
        textAlign = Paint.Align.CENTER
        textSize = 55.0f
        typeface = Typeface.create("", Typeface.BOLD)
        color = Color.YELLOW
    }

    init {
        isClickable = true
        context.obtainStyledAttributes(attr, R.styleable.DesignButton, defStyle, 0).apply {
            textColor = getColor(R.styleable.DesignButton_text_color, 0)
            _backgroundColor = getColor(R.styleable.DesignButton_background_color, 0)
            backgroundProgressColor =
                getColor(R.styleable.DesignButton_background_progress_color, 0)
            circleColor = getColor(R.styleable.DesignButton_circle_color, 0)
            circleProgressColor = getColor(R.styleable.DesignButton_circle_progress_color, 0)
            text = getString(R.styleable.DesignButton_text).toString()
        }


    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        widthSize = w
        heightSize = h
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = _backgroundColor
        canvas?.drawRoundRect(
            0f,
            0f,
            widthSize.toFloat(),
            heightSize.toFloat(),
            50f,
            50f,
            paint
        )
        paint.color = backgroundProgressColor
        canvas?.drawRoundRect(
            0f,
            0f,
            (widthSize * (progress / 100f)),
            heightSize.toFloat(),
            50f,
            50f,
            paint
        )

        paint.color = textColor
        canvas?.drawText(
            text,
            (widthSize / 2).toFloat(),
            (heightSize / 2).toFloat() + 20,
            paint
        )

        // draw small circle
        paint.color = circleColor
        canvas?.drawArc(
            (widthSize - 100).toFloat(),
            (heightSize / 2 - 30).toFloat(),
            (widthSize - 50).toFloat(),
            (heightSize / 2 + 30).toFloat(),
            0f,
            360f,
            true,
            paint
        )
        paint.color = circleProgressColor
        canvas?.drawArc(
            (widthSize - 100).toFloat(),
            (heightSize / 2 - 40).toFloat(),
            (widthSize - 50).toFloat(),
            (heightSize / 2 + 40).toFloat(),
            0f,
            (360 * (progress / 100f)),
            true,
            paint
        )

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }

    fun changeButtonState(state: ButtonState) {
        (context as Activity).runOnUiThread {
            this.buttonState = state
        }
    }

}