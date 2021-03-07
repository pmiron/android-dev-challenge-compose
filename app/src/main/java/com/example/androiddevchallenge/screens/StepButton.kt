package com.example.androiddevchallenge.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@ExperimentalAnimationApi
@Composable
fun StepButton(valueState: MutableState<Int>, range: IntRange, multiplier: Int = 1) {
    AnimatedVisibility(visible = true) {
        IconButton(onClick = {
            valueState.value = valueState.value + (1 * multiplier)
        }) {
            Icon(
                imageVector = if (multiplier > 0) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = ""
            )
        }
    }
}

