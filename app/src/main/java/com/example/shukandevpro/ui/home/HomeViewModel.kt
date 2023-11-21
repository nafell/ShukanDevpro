package com.example.shukandevpro.ui.home

import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shukandevpro.R
import com.example.shukandevpro.ui.AlertScreentimeActivity
import com.example.shukandevpro.ui.AlertHydrationActivity
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HomeViewModel(app: Application) : AndroidViewModel(app) {
    private val applicationContext = getApplication<Application>().applicationContext

    private val _titleMessage = MutableLiveData<String>().apply {
        val nowHour = LocalTime.now().hour
        value = when(nowHour) {
            in 4..9 -> "おはようございます、"
            in 10..17 -> "こんにちは、"
            else -> "こんばんは、"
        }
    }
    val titleMessage: LiveData<String> = _titleMessage

    private val _date = MutableLiveData<String>().apply {
//        val format = DateTimeFormatter.ofPattern("MM月dd日 (EEE)")
//        value = LocalTime.now().format(format)
        value = "11月21日 (火)"
    }
    val date: LiveData<String> = _date

    fun alertScreenTime() {
        makeNotification("遠くを見る時間です！", "目を休めましょう。", AlertScreentimeActivity::class.java)
    }
    fun alertHydration() {
        makeNotification("水を飲みましょう！", "喉が渇いていませんか?", AlertHydrationActivity::class.java)
    }
    @SuppressLint("MissingPermission")
    public fun makeNotification(title: String, text: String, activity: Class<*>) {
        val channelId = "CHANNEL_ID_WARN"

        // create notification channel
        val mChannel = NotificationChannel(channelId, "習慣アラート", NotificationManager.IMPORTANCE_HIGH)
        mChannel.description = "生活習慣の改善を提案します。"
        val notificationManager = NotificationManagerCompat.from(applicationContext)
        notificationManager.createNotificationChannel(mChannel)

        // create notification
        val builder = NotificationCompat.Builder(applicationContext, channelId)
        builder.setSmallIcon(R.drawable.notification_icon)
        builder.setContentTitle(title)
        builder.setContentText(text)
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // attach intent(start activity) to notification
        val intent = Intent(applicationContext, activity)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("data", "Some value to be passed here")
        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, PendingIntent.FLAG_MUTABLE)
        builder.setContentIntent(pendingIntent)

        // notify
        notificationManager.notify(1, builder.build())
    }
}