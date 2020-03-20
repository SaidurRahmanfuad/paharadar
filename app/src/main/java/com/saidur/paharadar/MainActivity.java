package com.saidur.paharadar;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.saidur.paharadar.ui.gurds.gurds;
import com.saidur.paharadar.ui.login.LoginActivity;
import com.saidur.paharadar.ui.notifications.Notification_ReciverFragment;
import com.saidur.paharadar.ui.notifications.broadcast_reciever.NotificationReciever;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    DatabaseReference onlineref,currentuserref,counterref;
   // TimePicker timePicker;
    private int notificationId=1;
    //User Id
    private String userid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_availableGurd, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        userid = FirebaseAuth.getInstance().getCurrentUser().getUid();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // FirebaseDatabase.getInstance().getReference("online").child(userid).setValue("0");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_join:
           /*     currentuserref.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(new gurds(FirebaseAuth.getInstance().getCurrentUser().getEmail(),"Online"));
           */     break;
            case R.id.action_logout:
               // currentuserref.removeValue();

                FirebaseDatabase.getInstance().getReference("online").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue("0");
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this,LoginActivity.class));
                finish();
            case R.id.action_notification:


               /* int hour= 21;
                int hour2= 19;
                int minit=10;
                int minit2=22;*/


                break;

                /*Calendar calenda=Calendar.getInstance();
                if(calenda.HOUR_OF_DAY==18)
                {
                    createnotificationChannel();
                }
                if(Calendar.HOUR_OF_DAY==5)
                {
                    createnotificationChannel2();
                }
                Calendar calendar=Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,6);
                calendar.set(Calendar.HOUR_OF_DAY,6);

                calendar.set(Calendar.MINUTE,15);
                calendar.set(Calendar.MINUTE,20);
                calendar.set(Calendar.SECOND,2);
                calendar.set(Calendar.SECOND,5);

                Intent goto_reciever = new Intent(MainActivity.this, NotificationReciever.class);
                PendingIntent pendingIntent= PendingIntent.getBroadcast(MainActivity.this,0,goto_reciever,0);
                AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
*/
              //  long timeatbtnclick=System.currentTimeMillis();
              //  long tensecinMill=1000*10;
                /*alarmManager.set(AlarmManager.RTC_WAKEUP,timeatbtnclick+tensecinMill,
                        pendingIntent);*/
               // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                /*Calendar calendar=Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,19);
                calendar.set(Calendar.MINUTE,55);
                calendar.set(Calendar.SECOND,12);
                Intent goto_reciever = new Intent(this, NotificationReciever.class);
                PendingIntent pendingIntent= PendingIntent.getBroadcast(this,100,goto_reciever,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);*/




        }

        return super.onOptionsItemSelected(item);
    }
   /* private void createnotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name = "ReminderChannel";
          //  CharSequence name1 = "ReminderChannel1";

            String description= "Channel for Reminder";
           // String description1= "Channel for Reminder1";
            int importence = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel=new NotificationChannel("notify",name,importence);
            //NotificationChannel channel1=new NotificationChannel("notify1",name1,importence);
            channel.setDescription(description);
           // channel.setDescription(description1);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
          //  notificationManager.createNotificationChannel(channel1);
        }

    }
    private void createnotificationChannel2() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name1 = "ReminderChannel2";
            String description1= "Channel 2";
            int importence = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel1=new NotificationChannel("notify1",name1,importence);;
            channel1.setDescription(description1);

            NotificationManager notificationManager1 = getSystemService(NotificationManager.class);
            notificationManager1.createNotificationChannel(channel1);
    }

}*/}
