package com.example.androiddevchallenge.viewmodel

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {


    val inEditMode = mutableStateOf(true)
    val sweepAngleState = mutableStateOf(360F)
    val secondProgressState = mutableStateOf(0)
    val minutesProgressState = mutableStateOf(0)
    val hoursProgressState = mutableStateOf(0)
    var animator: ValueAnimator? = null

    fun toggleEditMode() {
        inEditMode.value = !inEditMode.value
        if (inEditMode.value) {
            cancelTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() = viewModelScope.launch {
        var timeInSeconds =
            secondProgressState.value + (minutesProgressState.value * MINUTE_MULTIPLIER) + (hoursProgressState.value * HOUR_MULTIPLIER)
        if (timeInSeconds <= 0) return@launch

        animator = ValueAnimator.ofFloat(360F, 0F)
        animator?.duration = timeInSeconds * 1000L
        animator?.interpolator = LinearInterpolator()
        animator?.addUpdateListener {
            sweepAngleState.value = it.animatedValue as Float
        }
        animator?.start()
        while (timeInSeconds > 0 && !inEditMode.value) {
            updateTime(timeInSeconds--)
            delay(1000)
        }
        updateTime(0)
        cancel()
    }

    private fun updateTime(seconds: Int) {
        var timeInSeconds = seconds
        val hours = timeInSeconds / HOUR_MULTIPLIER
        timeInSeconds %= HOUR_MULTIPLIER
        val minutes = timeInSeconds / MINUTE_MULTIPLIER
        timeInSeconds %= MINUTE_MULTIPLIER

        hoursProgressState.value = hours
        minutesProgressState.value = minutes
        secondProgressState.value = timeInSeconds
    }

    private fun cancelTimer() {
        animator?.cancel()
        sweepAngleState.value = 360F
    }

    companion object {
        private const val HOUR_MULTIPLIER = 3600
        private const val MINUTE_MULTIPLIER = 60
    }
}