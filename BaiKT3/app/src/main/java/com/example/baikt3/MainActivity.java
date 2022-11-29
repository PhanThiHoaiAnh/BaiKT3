package com.example.baikt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Item> arrayList;
    private ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView_nn);
        arrayList = new ArrayList<>();
        arrayList.add(new Item("Tiếng Anh", "English",R.drawable.tienganh));
        arrayList.add(new Item("Tiếng Hàn", "Korea",R.drawable.han));
        arrayList.add(new Item("Tiếng Nga", "English",R.drawable.nga));
        arrayList.add(new Item("Tiếng Pháp", "Korea",R.drawable.phap));
        arrayList.add(new Item("Tiếng Trung", "English",R.drawable.trung));
        arrayList.add(new Item("Tiếng Việt", "Korea",R.drawable.tv));

        adapter = new ItemAdapter(MainActivity.this, R.layout.layout_item, arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TiengAnh.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TiengHan.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TiengNga.class);
                    startActivity(intent);
                }else if (i == 3) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TiengPhap.class);
                    startActivity(intent);
                }else if (i == 4) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TiengTrung.class);
                    startActivity(intent);
                }else if (i == 5) {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, TiengViet.class);
                    startActivity(intent);
                }
            }
        });

    }
}