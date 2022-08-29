package com.lloyd.weighttrackergraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lloyd.weighttrackergraph.ui.theme.WeightTrackerGraphTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeightTrackerGraphTheme {
                val navController = rememberNavController()
                val weightViewModel = ViewModelProvider(this)[WeightViewModel::class.java]
                NavHost(
                    navController = navController,
                    startDestination = Destination.Weight.route
                ) {
                    composable(route = Destination.Weight.route) {
                        WeightGraphScreen(weightViewModel = weightViewModel)
                    }
                }
            }
        }
    }
}