package oracle.huwl.com.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

/**
 * Created by aierxuan on 2017/7/14.
 */

public class MusicService extends Service{
    private MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action=intent.getStringExtra("action");
        Log.e("test",action+"---");
        if("play".equals(action)){
            Log.e("test",action+"--play");
            play();
        }else if("pause".equals(action)){
            pause();
        }
        else if("stop".equals(action)){
            stop();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void play(){
        startService(new Intent(this,MusicService.class));
        if(mediaPlayer==null){
            mediaPlayer= MediaPlayer.create(this,R.raw.birdgohome);
        }
        mediaPlayer.start();
    }
    public void pause(){
        if(mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }
    public void stop(){
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        stop();
    }
}
