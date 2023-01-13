package com.abdoalahmed.designbutton

sealed class ButtonState {
    object Completed : ButtonState()
    object Loading : ButtonState()
    object Clicked : ButtonState()
}