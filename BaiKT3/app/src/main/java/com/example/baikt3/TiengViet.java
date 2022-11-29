package com.example.baikt3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TiengViet extends AppCompatActivity {

    private EditText edtVidu;
    private Button buttonSave, buttonBack;
    private ListView listView;
    private ArrayList<NgonNgu> arrayList;
    private NgonNguAdapter adtNN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tieng_viet);

        buttonBack = findViewById(R.id.btnBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        buttonSave = findViewById(R.id.btnLuuViet);
        arrayList = new ArrayList<>();
        getData();
        adtNN = new NgonNguAdapter(this, R.layout.layout_show, arrayList);
        listView = (ListView) findViewById(R.id.listAnh);
        listView.setAdapter(adtNN);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

    }

    public void openMainActivity(){
        Intent intent = new Intent(TiengViet.this, MainActivity.class);
        startActivity(intent);
    }

    private void save() {
        String example;
        example = edtVidu.getText().toString();
        if (TextUtils.isEmpty(example)) {
            Toast.makeText(this, "Bạn chưa nhập ví dụ!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
    private  void getData() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("NgonNgu");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                    NgonNgu ngonNgu = data.getValue(NgonNgu.class);
                    if (ngonNgu != null) {
                        ngonNgu.setId(data.getKey());
                        adtNN.add(ngonNgu);
                    }
                }
                Toast.makeText(getApplicationContext(), "Thành công !", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Thất bại !" + error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("MYTAG", "onCancelled: " + error.toString());
            }
        });
    }

}