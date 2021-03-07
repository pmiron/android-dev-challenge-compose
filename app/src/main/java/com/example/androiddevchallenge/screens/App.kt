package com.example.androiddevchallenge.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
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
                if (counterViewModel.inEditMode.value) {
                    TimeEditor(counterViewModel = counterViewModel)
                } else {
                    TimeCounter(counterViewModel = counterViewModel)
                }
                Spacer(modifier = Modifier.height(24.dp))
                val iconValue =
                    if (counterViewModel.inEditMode.value) Icons.Filled.PlayArrow else Icons.Filled.Stop
                IconButton(
                    onClick = {
                        counterViewModel.toggleEditMode()
                    }
                ) {
                    Icon(imageVector = iconValue, contentDescription = "Start/Stop")
                }
            }
        }
    }
}

