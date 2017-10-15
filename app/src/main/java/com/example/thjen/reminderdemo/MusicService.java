package com.example.thjen.reminderdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MusicService extends Service {

    int id;
    public static MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("service", "Hi Service");

        String Stop = intent.getExtras().getString("extra");

        if ( Stop.equals("on") ) {
            id = 1;
        } else {
            id = 2;
        }

        if ( id == 1 ) {

            try {
                mediaPlayer = MediaPlayer.create(this, R.raw.viruss);
                mediaPlayer.start();
            } catch (Exception e ) {}

            Log.d("music", "Play");
            id = 2;

        } else {
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        return START_NOT_STICKY;
    }

}
