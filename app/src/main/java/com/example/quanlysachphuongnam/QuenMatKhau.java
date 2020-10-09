package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuenMatKhau extends AppCompatActivity {
    Button btngui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quen_mat_khau);
        btngui = findViewById(R.id.btnGui);
        btngui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuenMatKhau.this, DangNhap.class);
                startActivity(intent);

            }
        });
    }
}
