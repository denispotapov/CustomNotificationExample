package com.example.customnotificationexample

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.customnotificationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notificationManager = NotificationManagerCompat.from(this)

        showNotification()
    }

    private fun showNotification() {
        binding.btnShowNotification.setOnClickListener {
            val collapsedView = RemoteViews(packageName, R.layout.notification_collapsed)
            val expandedView = RemoteViews(packageName, R.layout.notification_expanded)

            val clickIntent = Intent(this, NotificationReceiver::class.java)
            val clickPendingIntent = PendingIntent.getBroadcast(this, 0, clickIntent, 0)

            collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World")
            expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.cat2)
            expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent)

            val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android)
                .setCustomContentView(collapsedView)
                .setCustomBigContentView(expandedView)
                //.setStyle(NotificationCompat.DecoratedCustomViewStyle())
                .build()

            notificationManager.notify(1, notification)
        }
    }
}