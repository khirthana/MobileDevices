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

public class BackgroundSoundService {


private static BackgroundSoundService refrence = null;

public static BackgroundSoundService getInstance(){
    if(refrence == null){
        refrence = new BackgroundSoundService ();
    }
    return refrence;
}
    public void initalizeMediaPlayer(Context context, int musicId){

// add initalization of media player in it and loop it
        MediaPlayer bkgrdmsc;
        bkgrdmsc = MediaPlayer.create(this, R.raw.bensound_memories);
        bkgrdmsc.setLooping(true);
    }

    public void startPlaying(){
        bkgrdmsc.start();
    }

    public void stopPlaying(){
        bkgrdmsc.stop();
    }


}
