package com.example.smartalarm

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartalarm.ui.theme.SetAlarmScreen

@Composable
fun MyApp(
    context: Context,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    // Define the navigation graph
    NavHost(navController = navController, startDestination = "Alarms") {
        composable("Alarms") { AlarmsScreen(
            context = context,
            navController = navController,
            modifier = modifier
        ) } // Screen 1
        composable("AlarmDetails/{alarmId}") {

            val alarmId = it.arguments?.getString("alarmId")?.toIntOrNull()

            SetAlarmScreen(
            context = context,
            navController = navController,
            alarmId = alarmId,
            modifier = modifier
        ) }          // Screen 2
    }
}

