package com.example.smartalarm

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

private const val TAG = "AlarmViewModel"
class AlarmViewModel : ViewModel() {
    private val _alarms = getAlarms().toMutableStateList()
    val alarm: List<Alarm>
        get() = _alarms

    fun remove(item: Alarm) {
        Log.d(TAG, "remove: $item")
        _alarms.remove(item)
        Log.d(TAG, "remove: $_alarms")
    }

    fun add(item: Alarm) {
        Log.d(TAG, "add: $item")
        _alarms.add(item)
        Log.d(TAG, "add: $_alarms")
    }

}
fun getAlarms() = List(3) { i -> Alarm(i, "Alarm #$i",10+i,10*i) }


