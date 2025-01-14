package com.example.smartalarm

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController


private const val TAG = "AlarmsScreen"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmsScreen(
    context: Context,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    alarmViewModel: AlarmViewModel = viewModel(),
    ) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.alarms)) }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
            ) {
                Column(modifier = modifier.padding(16.dp)) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        FloatingActionButton(
                            onClick = {
                                navController.navigate("AlarmDetails")
                            }, modifier = Modifier

                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = stringResource(R.string.add_entry),
                            )
                        }
                    }
                    AlarmList(
                        list = alarmViewModel.alarm,
                        onRemoveAlarm = { task -> alarmViewModel.remove(task) },
                        navController = navController,
                        modifier = modifier.padding(16.dp)
                    )
                }
            }
        }
    )

}




