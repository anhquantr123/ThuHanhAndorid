package com.example.btthuchanh4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    TextView tv1;
    String hoten,cm, bangcap,sothich,thongtinbosung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1= findViewById(R.id.name);

        hoten = getIntent().getStringExtra("hoten");
        cm = getIntent().getStringExtra("cm");
        bangcap = getIntent().getStringExtra("bangcap");
        sothich = getIntent().getStringExtra("sothich");
        thongtinbosung = getIntent().getStringExtra("bosung");
        //tv1.setText("");
        final String full = "Thông Tin Cơ Bản Của Bạn "+"Họ Tên: "+hoten+"CMND: " +
                ""+cm+"Bằng cấp: "+bangcap+"Sở thích: "+sothich+" "+thongtinbosung;
        tv1.setText(full);
        tv1.setSelected(true);



       //   tv1.setText(full.toString()+full.length());
    }
}