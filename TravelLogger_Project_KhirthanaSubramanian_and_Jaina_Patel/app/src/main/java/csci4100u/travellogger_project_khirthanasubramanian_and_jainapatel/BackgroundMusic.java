/*
    CSCI4100U Project - TravelLogger

    Team Members: Khirthana Subramanian(100453865) and Jaina Patel(100523188)

    BackgroundMusic: create media player to play music in loop in background
                     Music: bensound_memories.mp3 from http://www.bensound.com

 */
package csci4100u.travellogger_project_khirthanasubramanian_and_jainapatel;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import java.io.InputStream;

public class BackgroundMusic extends Service {

    MediaPlayer player;

    @Override
    public void onCreate() {
        super.onCreate();

        player = MediaPlayer.create(this, R.raw.bensound_memories);
        player.setLooping(true); // music in loop is enabled
        player.setVolume(100,100);

        player.start(); //music is started
    }

    /*
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;
    }
    public void onStart(Intent intent, int startId) {

    }
    /*/


    public void onStop() {
    }
    public void onPause() {
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

}
