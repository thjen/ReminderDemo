package com.example.thjen.reminderdemo;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StopActivity extends AppCompatActivity {

    Button btStop2;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_activity);

        btStop2 = (Button) findViewById(R.id.btStop2);

        btStop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Intent intent = new Intent(StopActivity.this, AlarmReceiver.class);
                try {
                    /** Flag cancel current **/
                    pendingIntent = PendingIntent.getBroadcast(StopActivity.this, Alarm.position ,intent, PendingIntent.FLAG_CANCEL_CURRENT);
                    pendingIntent.cancel();
                    intent.putExtra("extra", "off");
                    sendBroadcast(intent);
                    finish();
                } catch (Exception e) {}

            }
        });

    }

}
