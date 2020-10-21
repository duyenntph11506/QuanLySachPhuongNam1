//package com.example.quanlysachphuongnam;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.Dialog;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ListView;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.textfield.TextInputLayout;
//
//public class Main2Activity extends AppCompatActivity {
//    ListView listView;
//    FloatingActionButton floatingActionButton;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        listView = findViewById(R.id.lvtk);
//        floatingActionButton = findViewById(R.id.floatingActionButtontk);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Dialog dialog = new Dialog(Main2Activity.this);
//                dialog.setContentView(R.layout.dialogthemtheloai);
//                dialog.setCancelable(false);
//                Button button, button1;
//                final TextInputLayout txt1, txt2, txt3;
//                txt1 = dialog.findViewById(R.id.txt1);
//                txt2 = dialog.findViewById(R.id.txt2);
//                txt3 = dialog.findViewById(R.id.txt3);
//                button = dialog.findViewById(R.id.btnDangKyTk);
//                button1 = dialog.findViewById(R.id.btnhuyTK);
//
//                button1.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        dialog.cancel();
//
//                    }
//                });
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String name = txt1.getEditText().getText().toString().trim();
//                        String pass = txt2.getEditText().getText().toString().trim();
//                        String number = txt2.getEditText().getText().toString().trim();
//
//                        if (name.equals("") || pass.equals("") || )
//                    }
//                });
//                dialog.show();
//            }
//        });
//    }
//
//}
