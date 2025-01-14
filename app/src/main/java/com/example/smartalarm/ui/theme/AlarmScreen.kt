package com.example.smartalarm.ui.theme

import android.content.Context
import android.widget.EditText
import android.widget.LinearLayout
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.smartalarm.Alarm
import com.example.smartalarm.AlarmList
import com.example.smartalarm.AlarmViewModel
import com.example.smartalarm.R
import java.util.Calendar;
import androidx.compose.material3.TextField;

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetAlarmScreen(
    context: Context,
    navController: NavHostController,
    alarmId: Int? = null ,
    modifier: Modifier = Modifier,
    alarmViewModel: AlarmViewModel = viewModel()
) {
    var hour by remember { mutableIntStateOf(0) }
    var minute by remember { mutableIntStateOf(0) }
    var label by remember { mutableStateOf("") }
    var alarm : Alarm? =null;
    if (alarmId != null)
    {
        alarm = alarmViewModel.alarm[alarmId]
        label = alarm.label
        DialExample(alarm.hour, alarm.minute)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { if(alarmId != null) Text("Create Alarm") ?: Text("Alarm Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(
                            R.string.back
                        )
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text("Set Alarm", style = MaterialTheme.typography.headlineMedium)
                    if (alarm == null)
                        DialExample()
                    else
                        DialExample(alarm.hour, alarm.minute)
                    TextField(
                        value = label,
                        onValueChange = { label = it},
                        label= {Text("Alarm Name")}
                    )
                    Row {
                        Button(
                            onClick = {
                                alarmViewModel.add(
                                    Alarm(
                                        alarmId ?: alarmViewModel.alarm.size, label, hour, minute
                                    )
                                )
                                navController.navigate("Alarms")
                            },
                            modifier = modifier.fillMaxWidth()
                        ) {
                            Text(stringResource(R.string.set_alarm))
                        }
                        Button(
                            onClick = { navController.navigate("Alarms") },
                            modifier = modifier.fillMaxWidth()
                        ) {
                            Text(stringResource(R.string.cancel))
                        }
                    }

                }
            }
        }
    )


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialExample(hour: Int? = null, minute: Int? = null
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(hour ?: Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(minute ?: Calendar.MINUTE),
        is24Hour = true,
    )

    Column {
        TimePicker(
            state = timePickerState,
        )
    }
}

