package com.example.thjen.reminderdemo;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class Alarm extends AppCompatActivity {

    TimePicker timePicker;
    TextView tv;
    Button btDone, btStop;

    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    int position;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        tv = (TextView) findViewById(R.id.tv);
        btDone = (Button) findViewById(R.id.btDone);
        btStop = (Button) findViewById(R.id.btStop);

        final Calendar calendar = Calendar.getInstance();

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final Intent intent = new Intent(Alarm.this, AlarmReceiver.class);

        btDone.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                try {

                    calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                    calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());

                    int hour = timePicker.getCurrentHour();
                    int minute = timePicker.getCurrentMinute();

                    String Hour = String.valueOf(hour);
                    String Minute = String.valueOf(minute);

                    if (minute < 10) {
                        Minute = "0" + Minute;
                    }

                    Intent intent1 = getIntent();
                    position = intent1.getExtras().getInt("position");

                    intent.putExtra("extra", "on");

                    pendingIntent = PendingIntent.getBroadcast(Alarm.this, position, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                    alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                    tv.setText("Time Current: " + Hour + ":" + Minute);

                } catch (Exception e ) {}

            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    /** Flag cancel current **/
                    pendingIntent = PendingIntent.getBroadcast(Alarm.this, position ,intent, PendingIntent.FLAG_CANCEL_CURRENT);
                    pendingIntent.cancel();
                    intent.putExtra("extra", "off");
                    sendBroadcast(intent);
                } catch (Exception e) {}

            }
        });

    }


}
