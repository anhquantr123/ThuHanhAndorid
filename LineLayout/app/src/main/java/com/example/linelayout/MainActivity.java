package com.example.linelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // khai bao cac doi tuowng duoc su dung
        Button btncong,btntru,btnnhan,btnchia;
        final TextView  ketqua;
        final EditText edsoa,edsob;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa tim id cac doi tuong
        btncong = findViewById(R.id.btcong);
        btntru = findViewById(R.id.bttru);
        btnnhan = findViewById(R.id.btnhan);
        btnchia = findViewById(R.id.btchia);
        ketqua = findViewById(R.id.tvketqua);
        edsoa = findViewById(R.id.edSo_thu_nhat);
        edsob  = findViewById(R.id.edSo_thu_hai);


        // thuc hien cong
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final int soa  = Integer.parseInt(edsoa.getText().toString());
                    final int sob  = Integer.parseInt(edsob.getText().toString());
                    int c = soa + sob;
                    ketqua.setText("Kết Quả Cộng :"+c);
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Lỗi Phép Tính", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // thuc hien tru
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final int soa  = Integer.parseInt(edsoa.getText().toString());
                    final int sob  = Integer.parseInt(edsob.getText().toString());
                    int c = soa - sob;
                    ketqua.setText("Kết Quả Trừ :"+c);
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Lỗi Phép Tính", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // thưc hiện nhân
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final int soa  = Integer.parseInt(edsoa.getText().toString());
                    final int sob  = Integer.parseInt(edsob.getText().toString());
                    long c = soa *sob;
                    ketqua.setText("Kết Quả nhân :"+c);
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Lỗi Phép Tính", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // thực hiện chia
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final int soa  = Integer.parseInt(edsoa.getText().toString());
                    final int sob  = Integer.parseInt(edsob.getText().toString());
                    double c = (double)soa / sob;
                    ketqua.setText("Kết Quả chia :"+c);
                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Lỗi Phép Tính", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}