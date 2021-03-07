package com.example.androiddevchallenge.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    val secondProgressState = mutableStateOf(0)
    val minutesProgressState = mutableStateOf(0)
    val hoursProgressState = mutableStateOf(0)
}