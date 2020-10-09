package com.example.quanlysachphuongnam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Sach extends AppCompatActivity {
    List<ds> ds;
    ListView lvs;
    lvsach lvsach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        lvs = findViewById(R.id.lvSach);
        ds = new ArrayList<>();
        ds.add(new ds("ljkasfkl","alkjdfk","lkjaslfdk","kjjalkf","lkjafdjlk","lkjaf",67,"jlkajdjfs"));
        ds.add(new ds("ljkasfkl","alkjdfk","lkjaslfdk","kjjalkf","lkjafdjlk","lkjaf",67,"jlkajdjfs"));
        ds.add(new ds("ljkasfkl","alkjdfk","lkjaslfdk","kjjalkf","lkjafdjlk","lkjaf",67,"jlkajdjfs"));
        ds.add(new ds("ljkasfkl","alkjdfk","lkjaslfdk","kjjalkf","lkjafdjlk","lkjaf",67,"jlkajdjfs"));
        lvsach = new lvsach(ds,getApplicationContext(),R.layout.lvsach);
        lvs.setAdapter(lvsach);
    }
}
