package com.lloyd.weighttrackergraph

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun WeightGraphScreen(weightViewModel: WeightViewModel) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val lineDistance = size.width / weightViewModel.weightList.value.size
        var currentLineDistance = 0F + lineDistance
        weightViewModel.weightList.value.forEachIndexed { index, weight ->
            Log.d("Lloyd: ", "Weight $weight index $index")
            if (weightViewModel.weightList.value.size >= index + 2) {
                drawLine(
                    color = Color.Black,
                    start = Offset(
                        x = currentLineDistance,
                        y = weightViewModel.calculateYCoordinates(weight, size.height)
                    ),
                    end = Offset(
                        x = currentLineDistance + lineDistance,
                        y = weightViewModel.calculateYCoordinates(
                            weightViewModel.weightList.value[index + 1],
                            size.height
                        )
                    ),
                    strokeWidth = 5f
                )
            }

            currentLineDistance += lineDistance
        }

    }
}