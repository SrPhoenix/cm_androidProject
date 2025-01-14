package com.example.smartalarm
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun AlarmList(
    list: List<Alarm>,
    onRemoveAlarm: (Alarm) -> Unit,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = list, key = { alarm -> alarm.id }) { alarm ->
            AlarmListItem(alarmName = alarm.label, onRemove = {onRemoveAlarm(alarm)}, onUpdate = {navController.navigate("AlarmDetails/"+alarm.id)})
        }
    }
}
