package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DanhSachNguoiDung extends AppCompatActivity {

    ListView lv;
    lvuser lvuser;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_nguoi_dung);

        userList = new ArrayList<>();
        userList.add(new User(null,"aljskdf"));
        userList.add(new User(null,"aljskdf"));
        userList.add(new User(null,"aljskdf"));
        userList.add(new User(null,"aljskdf"));
        userList.add(new User(null,"aljskdf"));
        userList.add(new User(null,"aljskdf"));
        lv = findViewById(R.id.lvUser);
        lvuser = new lvuser(userList,getApplicationContext(),R.layout.lvuser);
        lv.setAdapter(lvuser);
    }
}
