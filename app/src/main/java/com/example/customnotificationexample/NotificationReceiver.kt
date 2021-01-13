package com.example.customnotificationexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, p1: Intent?) {
        Toast.makeText(context, "Image Clicked", Toast.LENGTH_SHORT).show()

        val notificationManager = NotificationManagerCompat.from(context!!)
        notificationManager.cancel(1)

    }
}