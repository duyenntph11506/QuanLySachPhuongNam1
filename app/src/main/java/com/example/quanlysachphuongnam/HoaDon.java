package com.example.quanlysachphuongnam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlysachphuongnam.adapter.ListviewHoaDon;
import com.example.quanlysachphuongnam.model.HoaDons;
import com.example.quanlysachphuongnam.sql.HoaDonDao;
import com.example.quanlysachphuongnam.sql.mysql;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class HoaDon extends AppCompatActivity {
    Toolbar toolbar;
    Button btn1, btn2;
    TextInputEditText textInputEditText1;
    TextInputEditText textInputEditText2;
    Spinner spn;
    SearchView searchView;
    ListviewHoaDon listviewHoaDon;
    List<HoaDons> hoaDonsList;
    ListView lvSearch;
    ListView lv;
    ArrayAdapter arrayAdapter ;
    List<String> listMa;
    CardView cardView;
HoaDonDao hoaDonDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        toolbar = findViewById(R.id.toolbarSach);
        setSupportActionBar(toolbar);
        searchView = findViewById(R.id.searchSach);
        lv  = findViewById(R.id.lvHD);
        lvSearch = findViewById(R.id.lvSachSearch);
        cardView = findViewById(R.id.carviewS);
        listMa = new ArrayList<>();
        hoaDonsList = new ArrayList<>();
      hoaDonDao = new HoaDonDao(new mysql(HoaDon.this));
      hoaDonsList = hoaDonDao.getData();
        listviewHoaDon = new ListviewHoaDon(hoaDonsList,HoaDon.this,R.layout.lvhoadon);
        lv.setAdapter(listviewHoaDon);


        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,listMa);
        lvSearch.setAdapter(arrayAdapter);

        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false) {
                    cardView.setVisibility(View.GONE);
                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                if (listMa.size() == 0) {
                    cardView.setVisibility(View.GONE);
                } else {
                    cardView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });




    }




    public void filter(String text) {
        if (text.trim().length() == 0) {
            listMa.clear();
        } else {
            listMa.clear();
            for (int i = 0; i < hoaDonsList.size(); i++) {
                listMa.add(hoaDonsList.get(i).getMaHoaDon());
            }
            for (int i = 0; i < listMa.size(); i++) {
                String ma = listMa.get(i);
                if (listMa.get(i).contains(text) == false) {
                    listMa.remove(i);
                    i--;
                }
            }
        }
        arrayAdapter.notifyDataSetChanged();
    }

    public int checkMa(String ma) {

        if (ma.equals("")){
            return 0;
        }

        for (int i = 0; i < hoaDonsList.size(); i++) {
            if (ma.equals(hoaDonsList.get(i).getMaHoaDon())) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemThem:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.themhoadon);
                btn1 = dialog.findViewById(R.id.btnthemhoadon);
                btn2 = dialog.findViewById(R.id.btnhuyhoadon);
                textInputEditText1 = dialog.findViewById(R.id.idthemmahoadon);
                textInputEditText2 = dialog.findViewById(R.id.idthemsoluonghoadon);
                spn = dialog.findViewById(R.id.spnMaSach);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String ma = textInputEditText1.getText().toString().trim();
                        String soLuong = textInputEditText2.getText().toString().trim();
                       HoaDons hoaDons = new HoaDons(ma,"");
                        hoaDonsList.add(hoaDons);
                        lv.deferNotifyDataSetChanged();
                        hoaDonDao.insert(hoaDons);
                        dialog.cancel();
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                break;
            case R.id.itemSua:
                Toast.makeText(this, "Sửa", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemXoa:
                Toast.makeText(this, "Xóa", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
