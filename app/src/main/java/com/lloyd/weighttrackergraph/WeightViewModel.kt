package com.lloyd.weighttrackergraph

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WeightViewModel : ViewModel() {
    val weightList: MutableState<List<Float>> = mutableStateOf(emptyList())

    private val weight =
        Weight(listOfWeights = weightList.value, maxWeight = 112f)

    init {
        buildWeightList()
    }

    fun calculateYCoordinates(currentWeight: Float, screenHeight: Float): Float {
        val maxWeightAndCurrentWeightDiff = weight.maxWeight - currentWeight
        val relativeScreenHeight = screenHeight / weight.maxWeight
        return (maxWeightAndCurrentWeightDiff * relativeScreenHeight) + 700f
    }

    private fun buildWeightList() {
        weightList.value = listOf(
            120f,
            122f,
            115f,
            112f,
            110f,

        )
    }
}