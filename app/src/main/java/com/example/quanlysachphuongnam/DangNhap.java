package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DangNhap extends AppCompatActivity {
    Button buttonDn;
    Button buttonDk;
    TextView tvQMK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        buttonDn = findViewById(R.id.btnDangNhap);
        buttonDk = findViewById(R.id.btnDangKy);
        tvQMK = findViewById(R.id.tvQMK);
        buttonDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this,PhuongNam.class);
                startActivity(intent);

            }
        });
        buttonDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this,DangKi.class);
                startActivity(intent);
            }
        });
        tvQMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, QuenMatKhau.class);
                startActivity(intent);
            }
        });


    }
}
