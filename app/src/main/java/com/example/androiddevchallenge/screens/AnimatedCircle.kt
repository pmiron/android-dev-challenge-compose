package com.example.androiddevchallenge.screens

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.purple700
import com.example.androiddevchallenge.viewmodel.CounterViewModel

@Composable
fun AnimatedCircle(modifier: Modifier = Modifier, counterViewModel: CounterViewModel) {
    val stroke = with(LocalDensity.current) {
        Stroke(
            22.dp.toPx()
        )
    }
    Canvas(modifier) {
        val innerRadius = (size.minDimension - stroke.width) / 2
        val halfSize = size / 2.0f
        val topLeft = Offset(
            halfSize.width - innerRadius,
            halfSize.height - innerRadius
        )
        val size = Size(innerRadius * 2, innerRadius * 2)
        val startAngle = -90F
        drawArc(
            color = purple700,
            startAngle = startAngle,
            sweepAngle = counterViewModel.sweepAngleState.value,
            topLeft = topLeft,
            size = size,
            useCenter = false,
            style = stroke
        )
    }
}