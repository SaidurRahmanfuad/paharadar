package com.saidur.paharadar.ui.notifications;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.saidur.paharadar.MainActivity;
import com.saidur.paharadar.R;
import com.saidur.paharadar.ui.notifications.broadcast_reciever.NotificationReciever;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class Notification_ReciverFragment extends Fragment implements View.OnClickListener {


    private int notificationId=1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_notification__reciver, container, false);


        v.findViewById(R.id.set).setOnClickListener(this);
        v.findViewById(R.id.cancel);
        /*AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
        Calendar calendar= Calendar.getInstance();
        calendar.add(Calendar.SECOND,10);
        Intent notificationIntent=new Intent("com.saidur.paharadar.DISPLAY_NOTIFICATION");

        //Intent notificationIntent = new Intent(getContext(), NotificationReciever.class);
        PendingIntent broadcast = PendingIntent.getBroadcast(getContext(), 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        //Calendar cal = Calendar.getInstance();
        //cal.add(Calendar.SECOND, 20);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), broadcast);*/
    return v;
    }

    @Override
    public void onClick(View view) {
        EditText editText=view.findViewById(R.id.et);
        TimePicker timePicker=view.findViewById(R.id.timepicker);
        //String msg="My 1st";
        Intent goto_reciever = new Intent(getActivity(), NotificationReciever.class);
        goto_reciever.putExtra("notificationId",notificationId);
        goto_reciever.putExtra("todo",editText.getText().toString());
        PendingIntent alarmIntent= PendingIntent.getBroadcast(getActivity(),0,goto_reciever,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager= (AlarmManager) getContext().getSystemService(ALARM_SERVICE);

    switch (view.getId()){
        case R.id.set:
            int hour=timePicker.getCurrentHour();
            int minit=timePicker.getCurrentMinute();
            //create time
            Calendar calendar=Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,hour);
            calendar.set(Calendar.MINUTE,minit);
            calendar.set(Calendar.SECOND,0);
            long alarmStartTime=calendar.getTimeInMillis();
            //set alarm
            alarmManager.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);
            Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
            break;

    }
    }
}
