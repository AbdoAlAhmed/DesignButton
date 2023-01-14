package com.abdoalahmed.designbutton

sealed class ButtonState {
    object Completed : ButtonState()
    object Clicked : ButtonState()
}