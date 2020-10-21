package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;

import com.example.quanlysachphuongnam.adapter.ListviewUser;
import com.example.quanlysachphuongnam.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class QuanLyNguoiDung extends AppCompatActivity {
    Toolbar toolbar;
    SearchView sv;
    ListviewUser listviewUser;
    ListView listView;
    List<NguoiDung> nguoiDungArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nguoi_dung);
        toolbar = findViewById(R.id.toolbarSach);
        sv = findViewById(R.id.searchSach);
        listView = findViewById(R.id.lvND);
        setSupportActionBar(toolbar);
        nguoiDungArrayList = new ArrayList<>();
        nguoiDungArrayList.add(new NguoiDung("abc","97847","sàlksdaj"));
        nguoiDungArrayList.add(new NguoiDung("abc","97847","sàlksdaj"));
        nguoiDungArrayList.add(new NguoiDung("abc","97847","sàlksdaj"));
        nguoiDungArrayList.add(new NguoiDung("abc","97847","sàlksdaj"));
        nguoiDungArrayList.add(new NguoiDung("abc","97847","sàlksdaj"));

        listviewUser = new ListviewUser(nguoiDungArrayList,QuanLyNguoiDung.this,R.layout.lvnguoidung);
        listView.setAdapter(listviewUser);

    }
}
