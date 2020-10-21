package com.example.quanlysachphuongnam;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysachphuongnam.adapter.Custom_spinner;
import com.example.quanlysachphuongnam.adapter.ListviewSach;
import com.example.quanlysachphuongnam.adapter.adapter_TheLoai;
import com.example.quanlysachphuongnam.model.Sach;
import com.example.quanlysachphuongnam.model.TheLoai;
import com.example.quanlysachphuongnam.sql.sach_DAO;
import com.example.quanlysachphuongnam.sql.theloai;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SachActivity extends AppCompatActivity {

    ListView lvs;
    ListviewSach listviewSach;
    List<Sach> sachList;
    List<TheLoai> TLList;
    theloai theloai_dao;
    sach_DAO sach_dao;

    theloai theloai;
    FloatingActionButton floatingActionButton;

    String textItem,subtextItem;
    int mposition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        lvs = findViewById(R.id.lvSach);
        theloai_dao = new theloai(SachActivity.this);
        sach_dao = new sach_DAO(SachActivity.this);
        floatingActionButton = findViewById(R.id.floatingActionButtonThemSach);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(SachActivity.this);
                dialog.setContentView(R.layout.dialog_themsach);
                dialog.setCancelable(false);
                Button btnThem, btnHuy;
                Spinner tvTL;
                final TextInputLayout tvMa, tvTen, tvDonGia, tvNXB, tvSL, tvNgayNhap, tvTacGia;
                btnThem = dialog.findViewById(R.id.btnNhapSach);
                btnHuy = dialog.findViewById(R.id.btnHuySach);
                tvMa = dialog.findViewById(R.id.inputMaSach);
                tvTen = dialog.findViewById(R.id.inputTenSach);
                tvDonGia = dialog.findViewById(R.id.inputGiaBan);
                tvNXB = dialog.findViewById(R.id.inputNhaXB);
                tvSL = dialog.findViewById(R.id.inputSoLuong);
                tvNgayNhap = dialog.findViewById(R.id.inputNgayNhap);
                tvTL = dialog.findViewById(R.id.inputTheLoai);
                tvTacGia = dialog.findViewById(R.id.inputTacGia);

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                //Ngày Thang Năm
                Calendar calendar = Calendar.getInstance();
                final int y = calendar.get(Calendar.YEAR);
                final int m = calendar.get(Calendar.MONTH);
                final int d = calendar.get(Calendar.DAY_OF_MONTH);

                TLList = new ArrayList<>();
                TLList = theloai_dao.getData();
                TheLoai theLoai = new TheLoai("-1", "Vui Lòng Chọn Thể Loại");
                TLList.add(0, theLoai);

                final Custom_spinner arrayAdapter = new Custom_spinner(SachActivity.this, TLList);
                tvTL.setAdapter(arrayAdapter);
        final String theloai[] = new String[1];
                tvTL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                       theloai[0]  = TLList.get(position).getTenTheLoai();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                tvNgayNhap.getEditText().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog datePickerDialog = new DatePickerDialog(SachActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvNgayNhap.getEditText().setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                            }
                        }, y, m, d);
                        datePickerDialog.show();
                    }
                });


                btnThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String maS = tvMa.getEditText().getText().toString().trim();
                        String TenS = tvTen.getEditText().getText().toString().trim();
                        String DonGia = tvDonGia.getEditText().getText().toString().trim();
                        String NXB = tvNXB.getEditText().getText().toString().trim();
                        String NgayNhap = tvNgayNhap.getEditText().getText().toString().trim();
                        String soLuong = tvSL.getEditText().getText().toString().trim();
                        String Tacgia = tvTacGia.getEditText().getText().toString().trim();


                        if (maS.equals("") || TenS.equals("") || DonGia.equals("") || NXB.equals("") || NgayNhap.equals("") || soLuong.equals("") || Tacgia.equals("")) {
                            Toast.makeText(SachActivity.this, "Bạn Không Được Để Trống", Toast.LENGTH_SHORT).show();
                        } else {
                            Pattern pattern = Pattern.compile(".*\\D.");
                            Matcher matcher1 = pattern.matcher(tvDonGia.getEditText().getText().toString().trim());
                            Matcher matcher2 = pattern.matcher(tvSL.getEditText().getText().toString().trim());

                            if (matcher2.matches()) {
                                tvSL.setError("Bạn Phải Nhập Vào 1 Số");
                            } else {
                                tvSL.setError(null);
                            }

                            if (matcher1.matches()) {
                                tvDonGia.setError("Bạn Phải Nhập Vào 1 Số");
                            } else {
                                tvDonGia.setError(null);
                            }

//them sach
                            Sach sach = new Sach();
                            sach.setTheLoai(theloai[0]);
                            sach.setMa(maS);
                            sach.setTen(TenS);
                            try {
                                sach.setGia(Double.parseDouble(DonGia));
                                sach.setSoLuong(Integer.parseInt(soLuong));
                            } catch (Exception e) {

                            }
                            sach.setNhaxuatban(NXB);

                            sach.setThoigian(NgayNhap);
                            sach.setTacgia(Tacgia);
                            sach_dao.insert(sach);
                            sachList = sach_dao.getData();
                            listviewSach = new ListviewSach(sachList, SachActivity.this, R.layout.lvsach);
                            lvs.setAdapter(listviewSach);
                        }
                    }
                });
                dialog.show();
            }
        });


        sachList = sach_dao.getData();
        listviewSach = new ListviewSach(sachList, SachActivity.this, R.layout.lvsach);
        lvs.setAdapter(listviewSach);
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
                    sach_DAO.delete(textItem);
                    Toast.makeText(this, "Xóa Thành Công", Toast.LENGTH_LONG).show();
                    sachList.remove(mposition);
                    adapter_TheLoai adapter_theLoai = new adapter_TheLoai(SachActivity.this,sachList);
                    listviewSach.setAdapter(listviewSach);
                }catch (Exception ex){
                    Toast.makeText(this, "Xóa Không Thành Công", Toast.LENGTH_LONG).show();
                }
                break;
            case 1:
                final Dialog dialog = new Dialog(SachActivity.this);
                dialog.setContentView(R.layout.dialog_sua_sach);
                dialog.setCancelable(false);
                final EditText editText;
                Button button,button1;
                button = dialog.findViewById(R.id.buttonSuaSach);
                button1 = dialog.findViewById(R.id.buttonHuySuaSach);
                editText = dialog.findViewById(R.id.edTenS);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Sach sach = new Sach();
                        Sach.setTenSach(editText.getText().toString());
                        sach_DAO.update(sach,textItem);
                        sachList = sach_DAO.getData();
                        ListviewSach listviewSach = new ListviewSach(sachList,SachActivity.this,R.layout.lvsach );
                        lvs.setAdapter(listviewSach);
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
