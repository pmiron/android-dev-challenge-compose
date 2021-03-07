package com.example.androiddevchallenge.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.titleTextStyle
import com.example.androiddevchallenge.viewmodel.CounterViewModel

@ExperimentalAnimationApi
@Composable
fun App(counterViewModel: CounterViewModel) {
    Scaffold(
        topBar = {
            Text(
                text = "JetpackTimer", style = titleTextStyle,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 20.dp)
                    .height(80.dp),
                textAlign = TextAlign.Center
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
                Spacer(modifier = Modifier.height(24.dp))
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "Start")
                }
            }
        }
    }
}