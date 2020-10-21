package com.example.quanlysachphuongnam;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysachphuongnam.adapter.adapter_TheLoai;
import com.example.quanlysachphuongnam.sql.theloai;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class TheLoai extends AppCompatActivity {
    ListView listView;
    FloatingActionButton floatingActionButton;
    theloai theloai;
    List<com.example.quanlysachphuongnam.model.TheLoai> theLoaiList;
    String textItem,subtextItem;
    int mposition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        listView = findViewById(R.id.lvtk);
        floatingActionButton = findViewById(R.id.floatingActionButtontk);
        registerForContextMenu(listView);
        theloai = new theloai(TheLoai.this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(TheLoai.this);
                dialog.setContentView(R.layout.dialogthemtheloai);
                dialog.setCancelable(false);
                Button button, button1;
                final TextInputLayout txtMaTL, txtTenTL;

                txtMaTL = dialog.findViewById(R.id.textInputLayout8);
                txtTenTL = dialog.findViewById(R.id.textInputLayout9);
                button = dialog.findViewById(R.id.btnThem);
                button1 = dialog.findViewById(R.id.btnHuy);


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String maTL = txtMaTL.getEditText().getText().toString().trim();
                        String tenTL = txtTenTL.getEditText().getText().toString().trim();
                        if (maTL.equals("") || tenTL.equals("")) {
                            txtMaTL.setError("Bạn Không Được Để Trống");
                            txtTenTL.setError("Bạn Không Được Để Trống");
                        } else {
                            txtMaTL.setError(null);
                            txtTenTL.setError(null);
                            com.example.quanlysachphuongnam.model.TheLoai theLoai = new com.example.quanlysachphuongnam.model.TheLoai();
                            theLoai.setMa(maTL);
                            theLoai.setTenTheLoai(tenTL);
                            theloai.insert(theLoai);
                            theLoaiList = theloai.getData();

                            adapter_TheLoai adapter_theLoai = new adapter_TheLoai(TheLoai.this, theLoaiList);
                            listView.setAdapter(adapter_theLoai);
                        }
                    }
                });

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });

        theLoaiList = theloai.getData();

        adapter_TheLoai adapter_theLoai = new adapter_TheLoai(TheLoai.this, theLoaiList);
        listView.setAdapter(adapter_theLoai);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textItem = theLoaiList.get(position).getMa();
                mposition = position;
            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE,0,0,"Xóa");
        menu.add(Menu.NONE,1,0,"Sửa");
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case 0:
                try {
                    theloai.delete(textItem);
                    Toast.makeText(this, "Xóa Thành Công", Toast.LENGTH_LONG).show();
                    theLoaiList.remove(mposition);
                    adapter_TheLoai adapter_theLoai = new adapter_TheLoai(TheLoai.this, theLoaiList);
                    listView.setAdapter(adapter_theLoai);
                }catch (Exception ex){
                    Toast.makeText(this, "Xóa Không Thành Công", Toast.LENGTH_LONG).show();
                }
                break;
            case 1:
                final Dialog dialog = new Dialog(TheLoai.this);
                dialog.setContentView(R.layout.dialog_sua_tl);
                dialog.setCancelable(false);
                final EditText editText;
                Button button,button1;
                button = dialog.findViewById(R.id.buttonSuaSach);
                button1 = dialog.findViewById(R.id.buttonHuySuaSach);
                editText = dialog.findViewById(R.id.edTenS);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        com.example.quanlysachphuongnam.model.TheLoai theLoai = new com.example.quanlysachphuongnam.model.TheLoai();
                        theLoai.setTenTheLoai(editText.getText().toString());
                        theloai.update(theLoai,textItem);
                        theLoaiList = theloai.getData();
                        adapter_TheLoai adapter_theLoai = new adapter_TheLoai(TheLoai.this, theLoaiList);
                        listView.setAdapter(adapter_theLoai);
                    }
                });

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
