package com.example.androiddevchallenge.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun Picker(valueState: MutableState<Int>) {
    Column(
        modifier = Modifier.width(45.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        StepButton(valueState, range = 0..23, 1)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${valueState.value}"
        )
        Spacer(modifier = Modifier.height(8.dp))
        StepButton(valueState, range = 0..23, multiplier = -1)
    }
}