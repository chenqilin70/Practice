package oracle.huwl.com.helloandroidstudio;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestListView extends Activity {
    private ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_test_list_view);
        list_view= (ListView) findViewById(R.id.list_view);
        String[] data={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.item_array_adapter,data);
        list_view.setAdapter(adapter);
    }

}
