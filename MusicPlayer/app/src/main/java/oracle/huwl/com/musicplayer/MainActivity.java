package oracle.huwl.com.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent(this,MusicService.class);
    }
    public void play(View v){
        intent.putExtra("action","play");
        startService(intent);
    }
    public void pause(View v){
        intent.putExtra("action","pause");
        startService(intent);
    }
    public void stop(View v){
        intent.putExtra("action","stop");
        startService(intent);
    }
    public void exit(View v){
        stopService(intent);
        finish();
    }


}
