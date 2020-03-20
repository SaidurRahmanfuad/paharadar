package com.saidur.paharadar.ui.notifications.broadcast_reciever;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.saidur.paharadar.MainActivity;
import com.saidur.paharadar.R;
import com.saidur.paharadar.ui.dashboard.DashboardFragment;
import com.saidur.paharadar.ui.notifications.Notification_ReciverFragment;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

public class NotificationReciever extends BroadcastReceiver {
  //  private static final String CHANNEL_ID = "com.saidur.paharadar.ui.notifications.channelId";
    @Override
    public void onReceive(Context context, Intent intent) {
        //get id & msg from intent
        int notificationId= intent.getIntExtra("notificationId",0);
        String massage= intent.getStringExtra("todo");
        //when notifiction is tapped

        Intent mainIntent= new Intent(context, MainActivity.class);
        PendingIntent contentIntent= PendingIntent.getActivity(context,0,mainIntent,0);
        NotificationManager myNotificationmnger=(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Notification.Builder builder=new Notification.Builder(context);
        //NotificationCompat.Builder builder= new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.ic_done)
                .setContentTitle("It's Title")
                .setContentText(massage)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_ALL);

        //notify
        myNotificationmnger.notify(notificationId,builder.build());

        //prepare notification


        /*NotificationCompat.Builder builder= new NotificationCompat.Builder(context,"notify")
                .setSmallIcon(R.drawable.ic_done)
                .setContentTitle("Remind")
                .setContentText("khabar shomoy")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(0,builder.build());

        NotificationCompat.Builder builder1= new NotificationCompat.Builder(context,"notify1")
                .setSmallIcon(R.drawable.ic_done)
                .setContentTitle("number2")
                .setContentText("2nd notification")
                .setPriority(NotificationCompat.PRIORITY_LOW);
        NotificationManagerCompat notificationManagerCompat1 = NotificationManagerCompat.from(context);
        notificationManagerCompat1.notify(0,builder1.build());
*/
      /*  NotificationManager notificationManager= (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        Intent repeat_activity = new Intent(context, Notification_ReciverFragment.class);
        repeat_activity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(context,100,repeat_activity,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder_notification = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_done)
                .setContentTitle("Paharadar")
                .setContentText("Hajira din")
                .setAutoCancel(true);
        notificationManager.notify(100,builder_notification.build());*/

        /*Intent notificationIntent = new Intent(context, DashboardFragment.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(DashboardFragment.class);
        stackBuilder.addNextIntent(notificationIntent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(100, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder = new Notification.Builder(context);

        Notification notification = builder.setContentTitle("Demo App Notification")
                .setContentText("New Notification From Demo App..")
                .setTicker("New Message Alert!")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent).build();

       *//* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID);
        }*//*

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

      *//*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "NotificationDemo",
                    NotificationManagerCompat.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);
        }*//*

        notificationManager.notify(0, notification);*/
    }
}
