package com.example.btthuchanh4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button btGui;
     EditText edhoten1,edcmnd1;
     RadioButton ra1,ra2,ra3;
     CheckBox ch1,ch2,ch3;
     String hoten,cm, bangcap,sothich,thongtinbosung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btGui = findViewById(R.id.btsend);

        edhoten1 = findViewById(R.id.edhoten);
        edcmnd1 = findViewById(R.id.edcmnd);

        ra1 = findViewById(R.id.rdtrungcap);
        ra2 = findViewById(R.id.rdcaodang);
        ra3 = findViewById(R.id.rddaihoc);

        ch1 = findViewById(R.id.rddocbao);
        ch2= findViewById(R.id.rddocsach);
        ch3 = findViewById(R.id.rddoccoding);

        btGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                if(edhoten1.getText().equals("")){
                    Toast.makeText(MainActivity.this, "Vui Lòng Nhập Họ Và Tên", Toast.LENGTH_SHORT).show();
                    edhoten1.requestFocus();
                }else{
                    hoten = edhoten1.getText().toString().trim();
                }

                if(edcmnd1.getText().equals("")){
                    Toast.makeText(MainActivity.this, "Hãy Nhập CMND", Toast.LENGTH_SHORT).show();
                    edcmnd1.requestFocus();
                }else{
                    cm = edcmnd1.getText().toString().trim();
                }

                // bang cap
                if(ra1.isChecked()){
                    bangcap = ra1.getText().toString();
                }else if(ra2.isChecked()){
                    bangcap = ra2.getText().toString();
                } else if(ra3.isChecked()){
                    bangcap = ra3.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this, "Bạn chưa Chọn Bằng Cấp", Toast.LENGTH_SHORT).show();
                }
                // so thich
                if(ch1.isChecked()){
                    sothich = ch1.getText().toString();
                }else if(ra2.isChecked()){
                    sothich = ch2.getText().toString();
                } else if(ra3.isChecked()){
                    sothich = ch3.getText().toString();
                }else{
                    Toast.makeText(MainActivity.this, "Bạn chưa Chọn Sở Thich", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("hoten",hoten);
                intent.putExtra("cm",cm);
                intent.putExtra("bangcap",bangcap);
                intent.putExtra("sothich",sothich);
                intent.putExtra("bosung",thongtinbosung);
                startActivity(intent);
                finish();
            }
        });
    }
}