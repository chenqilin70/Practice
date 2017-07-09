package oracle.huwl.com.blacklist;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    private ListView lv_main;
    private PhoneNumDao dao;
    private List<PhoneNum> data;
    private BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao=new PhoneNumDao(this);
        data=dao.queryAll();
        lv_main=findViewById(R.id.lv_main);
        adapter=new PhoneAdapter();
        lv_main.setAdapter(adapter);
        lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int phoneIndex=i;
                new AlertDialog.Builder(MainActivity.this)
                        .setItems(new String[]{"删除", "修改"}, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(i==0){
                                    dao.delete(data.get(phoneIndex).get_id());
                                    data.remove(phoneIndex);
                                    adapter.notifyDataSetChanged();
                                }else if(i==1){
                                     View input_dialog=View.inflate(MainActivity.this,R.layout.input_dialog,null);
                                    final EditText et_add_num=input_dialog.findViewById(R.id.et_add_num);
                                    et_add_num.setText(data.get(phoneIndex).getNum());
                                    new AlertDialog.Builder(MainActivity.this)
                                            .setView(input_dialog)
                                            .setNegativeButton("取消",null)
                                            .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    String newNum=et_add_num.getText().toString();
                                                    data.get(phoneIndex).setNum(newNum);
                                                    dao.update(data.get(phoneIndex));
                                                    adapter.notifyDataSetChanged();
                                                }
                                            })
                                            .show();
                                }
                            }
                        })
                        .show();
            }
        });
    }
    public void addItem(View v){
        final View dialog=View.inflate(this,R.layout.input_dialog,null);
        new AlertDialog.Builder(this)
                .setView(dialog)
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText et_add_num=dialog.findViewById(R.id.et_add_num);
                        String newNum=et_add_num.getText().toString();
                        PhoneNum newPhone=new PhoneNum(null,newNum);
                        dao.add(newPhone);
                        data.add(newPhone);
                        adapter.notifyDataSetChanged();

                    }
                })
                .setNegativeButton("取消",null)
                .show();
    }
    class PhoneAdapter extends  BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=View.inflate(MainActivity.this,R.layout.item_phone,null);
            }
           TextView tv_num= view.findViewById(R.id.tv_num);
           tv_num.setText(data.get(i).getNum()+"");
            return view;
        }
    }
}
