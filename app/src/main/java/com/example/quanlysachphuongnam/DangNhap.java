package com.example.quanlysachphuongnam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysachphuongnam.model.NguoiDung;
import com.example.quanlysachphuongnam.sql.NguoiDungDao;
import com.example.quanlysachphuongnam.sql.mysql;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class DangNhap extends AppCompatActivity {
    Button buttonDn;
    Button buttonDk;
    TextView tvQMK;
    TextInputEditText txt1, txt2;
    List<NguoiDung> nguoiDungList;
    NguoiDungDao nguoiDungDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        buttonDn = findViewById(R.id.btnDangNhap);
        buttonDk = findViewById(R.id.btnDangKyTk);
        tvQMK = findViewById(R.id.tvQMK);
        txt1 = findViewById(R.id.txtUserDN);
        txt2 = findViewById(R.id.txtPassDN);

        nguoiDungList = new ArrayList<>();
        nguoiDungDao = new NguoiDungDao(new mysql(this));
        nguoiDungList = nguoiDungDao.getAllUser();
        ;
        buttonDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernam = txt1.getText().toString().trim();
                String paseserword = txt2.getText().toString().trim();
                    if (checkUsser(usernam,paseserword)==true) {
                        Intent intent = new Intent(DangNhap.this, PhuongNam.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(DangNhap.this, "Sai tên tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    }

            }
        });
        buttonDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, DangKi.class);
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

    public boolean checkUsser(String user, String password) {
        for (int i = 0; i < nguoiDungList.size(); i++) {
            if (password.equals(nguoiDungList.get(i).getPassword()) && (user.equals(nguoiDungList.get(i).getName()) || (user.equals(nguoiDungList.get(i).getPhoneNumber())))) {
                return true;
            }
        }
        return false;
    }
}
