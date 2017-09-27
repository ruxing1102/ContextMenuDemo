package com.example.android.contextmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private Button btn_show_menu;
    private ListView lv_list;
    private MyAdapter adapter;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_list = (ListView) findViewById(R.id.lv_list);
        btn_show_menu=(Button)findViewById(R.id.btn_button);
        btn_show_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv_list.showContextMenu();
            }
        });

        list = new ArrayList<>();
        list.add("隐形的翅膀");
        list.add("有形的翅膀");
        list.add("亲爱的那不是爱情");
        list.add("欧若拉");
        list.add("看的最远的地方");
        list.add("梦里花");
        list.add("遗失的美好");
        list.add("寓言");

        adapter = new MyAdapter(this, list);
        lv_list.setAdapter(adapter);

        registerForContextMenu(lv_list);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //给menu设置布局文件，当触发的时候显示在界面上
        getMenuInflater().inflate(R.menu.main_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_one:
                Toast.makeText(MainActivity.this,"item_one被点击了",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_two:
                Toast.makeText(MainActivity.this,"item_two被点击了",Toast.LENGTH_LONG).show();
                break;
            case R.id.item_three:
                Toast.makeText(MainActivity.this,"item_three被点击了",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
