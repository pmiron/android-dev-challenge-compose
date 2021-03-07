package com.example.androiddevchallenge.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.viewmodel.CounterViewModel

@ExperimentalAnimationApi
@Composable
fun TimeCounter(counterViewModel: CounterViewModel) {
    Card(
        modifier = Modifier.size(250.dp),
        elevation = 16.dp,
        shape = CircleShape
    ) {
        AnimatedCircle(
            modifier = Modifier.fillMaxSize(),
            counterViewModel
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${counterViewModel.hoursProgressState.value}"
            )
            Text(
                text = ":"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${counterViewModel.minutesProgressState.value}"
            )
            Text(
                text = ":"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${counterViewModel.secondProgressState.value}"
            )
        }
    }
}