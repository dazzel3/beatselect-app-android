package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button go_type1;
    Button go_type2;
    Button go_type3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_type1 = findViewById(R.id.btn_type1); // 감성 / 트렌드 / 팝 버튼
        go_type2 = findViewById(R.id.btn_type2); // 하드 / 어두움 / 힙합 버튼
        go_type3 = findViewById(R.id.btn_type3); // 밝음 / 신남 / 싱잉 버튼

        // 감성 / 트렌드 / 팝 버튼 클릭 시, Type1 액티비티로 이동
        go_type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Type1.class);
                startActivity(intent);
            }
        });

        // 하드 / 어두움 / 힙합 버튼 클릭 시, Type2 액티비티로 이동
        go_type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Type2.class);
                startActivity(intent);
            }
        });

        // 밝음 / 신남 / 싱잉 버튼 클릭 시, Type3 액티비티로 이동
        go_type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Type3.class);
                startActivity(intent);
            }
        });

    }
}