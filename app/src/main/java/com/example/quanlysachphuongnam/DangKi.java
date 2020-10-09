package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DangKi extends AppCompatActivity {
    Button buttonDk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        buttonDk = findViewById(R.id.btnDangKy);
        buttonDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKi.this,DangNhap.class);
                startActivity(intent);
            }
        });
    }
}
