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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.viewmodel.CounterViewModel

@ExperimentalAnimationApi
@Composable
fun TimeEditor(counterViewModel: CounterViewModel) {
    Card(
        modifier = Modifier.size(250.dp),
        elevation = 16.dp,
        shape = CircleShape
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Picker(counterViewModel.hoursProgressState)
            Spacer(modifier = Modifier.width(8.dp))
            Picker(counterViewModel.minutesProgressState)
            Spacer(modifier = Modifier.width(8.dp))
            Picker(counterViewModel.secondProgressState)
        }
    }
}