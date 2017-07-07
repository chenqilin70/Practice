package oracle.huwl.com.testnetwork;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText et_result,et_nw_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_result= findViewById(R.id.et_result);
        et_nw_url= findViewById(R.id.et_nw_url);
    }
    public void testHttpUrlConnectionGet(View v){

    }
    public void testHttpUrlConnectionPost(View v){

    }
    public void testHttpClientGet(View v){

    }
    public void testHttpClientPost(View v){

    }
    public void testVolleyGet (View v){

    }
    public void testVolleyPost(View v){

    }
}
