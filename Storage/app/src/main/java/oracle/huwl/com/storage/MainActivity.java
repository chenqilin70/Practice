package oracle.huwl.com.storage;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void testSharePreference(View v){
        startActivity(new Intent(this,SpActivity.class));
    }
    public void testInnerFile(View v){
        startActivity(new Intent(this,IFActivity.class));
    }
    public void testOutterFile(View v){
        startActivity(new Intent(this,OFActivity.class));
    }
    public void testDatabase(View v){

    }
    public void testNetwork(View v){

    }
}
