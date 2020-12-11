package com.beoptimist.android.adhkar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReminderBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notify_morning")
                .setSmallIcon(R.mipmap.logo2)
                .setContentTitle("Invocations du matin ;-)")
                .setContentText("Il est le temps pour faire les invocations du matin ;-)")
                .setPriority(NotificationCompat.PRIORITY_HIGH);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(100, builder.build());
    }


}
