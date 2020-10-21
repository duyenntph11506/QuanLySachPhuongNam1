package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quanlysachphuongnam.model.NguoiDung;
import com.example.quanlysachphuongnam.sql.NguoiDungDao;
import com.example.quanlysachphuongnam.sql.mysql;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class DangKi extends AppCompatActivity {
    TextInputEditText textInputLayout, textInputLayout2, textInputLayout3;
    Button buttonDk, buttonHuy;
    NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        textInputLayout = findViewById(R.id.txtUserNameTK);
        textInputLayout2 = findViewById(R.id.txtPassDK);
        textInputLayout3 = findViewById(R.id.txtEmaiDK);
        buttonHuy = findViewById(R.id.btnHuyDk);
        buttonDk = findViewById(R.id.btnDangKyTk);

        nguoiDungDao = new NguoiDungDao(new mysql(this));
        buttonHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKi.this,DangNhap.class);
                startActivity(intent);
            }
        });

        buttonDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNam = textInputLayout.getText().toString().trim();
                String email = textInputLayout3.getText().toString().trim();
                String pass = textInputLayout2.getText().toString().trim();
                nguoiDungDao.themnguoidung(new NguoiDung(userNam,email,pass));
                Toast.makeText(DangKi.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DangKi.this,DangNhap.class);
                startActivity(intent);
            }
        });
    }
}
