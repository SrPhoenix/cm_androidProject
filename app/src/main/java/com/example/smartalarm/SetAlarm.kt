package com.example.smartalarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.RowScope
import java.util.Calendar

//fun setAlarm(context: RowScope, hour: Int, minute: Int) {
//    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//    val intent = Intent(context, AlarmReceiver::class.java)
//    val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//
//    val calendar = Calendar.getInstance().apply {
//        set(Calendar.HOUR_OF_DAY, hour)
//        set(Calendar.MINUTE, minute)
//        set(Calendar.SECOND, 0)
//    }
//
//    alarmManager.setExact(
//        AlarmManager.RTC_WAKEUP,
//        calendar.timeInMillis,
//        pendingIntent
//    )
//}