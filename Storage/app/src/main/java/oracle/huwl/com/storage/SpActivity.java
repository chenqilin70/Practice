package oracle.huwl.com.storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SpActivity extends Activity {
    private EditText et_key,et_value;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        et_key=findViewById(R.id.et_key);
        et_value=findViewById(R.id.et_value);
        sp=this.getSharedPreferences("oracle", Context.MODE_PRIVATE);
    }
    public void save(View v){
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(et_key.getText().toString(),et_value.getText().toString());
        editor.commit();
    }
    public void read(View v){
        String key=et_key.getText().toString();
        String value=sp.getString(key,"no value");
        ToastUtil.showDefaultToast(this,value);

    }
}
