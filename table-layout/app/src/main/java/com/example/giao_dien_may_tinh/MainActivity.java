package com.example.giao_dien_may_tinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,btn16, btn20,
            btnspack,btndelete,btnbang,btnkhong;
    TextView edbt, edkq;
    int nhanphim;
    double bieuthuc1,bieuthuc2,ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //editText
        edbt = findViewById(R.id.edbieuhuc);
        edkq = findViewById(R.id.edketqua);
        // number
        btn5 = findViewById(R.id.btmot);
        btn6 = findViewById(R.id.bthai);
        btn7 = findViewById(R.id.btba);
        btn8 = findViewById(R.id.btcong);
        btn9  = findViewById(R.id.btbon);
        btn10  = findViewById(R.id.btnam);
        btn11  = findViewById(R.id.btsau);
        btn12  = findViewById(R.id.bttru);
        btn13  = findViewById(R.id.btbay);
        btn14  = findViewById(R.id.bttam);
        btn15  = findViewById(R.id.btchin);
        btn16  = findViewById(R.id.btnhan);
        btn20 = findViewById(R.id.btchia);
        btnspack = findViewById(R.id.btspack);
        btndelete = findViewById(R.id.btC);
        btnbang = findViewById(R.id.btbang);
        btnkhong = findViewById(R.id.btkhong);

        edkq.setText("");
        // thuc hien tinh toan
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"1");
            }
        });
        btnkhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"0");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"2");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"3");
            }
        });
        // hang 4,5,6
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"4");
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"5");
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"6");
            }
        });
        //  hang 7,8,9
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"7");
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"8");
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edkq.setText(edkq.getText()+"9");
            }
        });
        // hang phim tinh toan
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   bieuthuc1= Double.parseDouble(edkq.getText().toString());
                   edbt.setText(edkq.getText().toString()+ " /");
                   nhanphim = 4;
                   edkq.setText("");
               }catch (Exception et){

               }

            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    bieuthuc1= Double.parseDouble(edkq.getText().toString());
                    edbt.setText(edkq.getText().toString()+ " *");
                    nhanphim = 3;
                    edkq.setText("");
                }catch (Exception et){

                }
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    bieuthuc1= Double.parseDouble(edkq.getText().toString());
                    edbt.setText(edkq.getText().toString()+ " -");
                    nhanphim = 2;
                    edkq.setText("");
                }catch (Exception et){

                }

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    bieuthuc1= Double.parseDouble(edkq.getText().toString());
                    edbt.setText(edkq.getText().toString()+ " +");
                    nhanphim = 1;
                    edkq.setText("");
                }catch (Exception et){

                }
            }
        });
        // hang phim khac de tinh toan
            // phim xoa 1 ki tu
        btnspack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(edkq.getText().equals("")){
                        StringBuilder build1 = new StringBuilder(edbt.getText().toString());
                        build1.deleteCharAt(build1.length()-1);
                        edkq.setText(build1.toString());
                        edbt.setText("");
                    }else{
                        StringBuilder build = new StringBuilder(edkq.getText().toString());
                        build.deleteCharAt(build.length()-1);
                        edkq.setText(build.toString());
                        // edbt.setText("");
                    }
                }catch (Exception ed){
                    btnspack.setEnabled(true);
                }

            }
        });
        // phim xoa tat ca cac ki tu
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bieuthuc1 = 0;
                edbt.setText("");
                edkq.setText("");
            }
        });
        // phim bang
        btnbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   bieuthuc2 = Double.parseDouble(edkq.getText().toString());
                   edbt.setText(edbt.getText().toString()+ edkq.getText().toString());
                   if(nhanphim == 1){
                       edkq.setText((bieuthuc1+ bieuthuc2)+"");
                   }
                   if(nhanphim == 2){
                       edkq.setText((bieuthuc1- bieuthuc2)+"");
                   }
                   if(nhanphim == 3){
                       edkq.setText((bieuthuc1* bieuthuc2)+"");
                   }
                   if(nhanphim == 4){
                       if(bieuthuc2 == 0){
                           Toast.makeText(MainActivity.this, "Biểu thức bạn nhập là 0 không thể thực hiện", Toast.LENGTH_SHORT).show();
                       }else {
                           edkq.setText((double) Math.round((bieuthuc1 / bieuthuc2) * 100000) / 100000 + "");
                       }
                   }
               }catch (Exception dd){

               }
            }
        });

    }
    public void test(View view){
        try {
            switch (view.getId()){
                case R.id.btcham:
                    edkq.setText(edkq.getText()+".");
                    break;
                case R.id.btamduong:
                    edkq.setText(edkq.getText()+"-");
                    break;
                case R.id.btxbinh:
                    double kq = Double.parseDouble(edkq.getText().toString());
                    edkq.setText(kq*kq+"");
                    //edbt.setText(edbt.getText()+""+kq+"²");
                    break;
                case R.id.xcanhai:
                    double kq1 = Double.parseDouble(edkq.getText().toString());
                    //edbt.setText(edbt.getText()+"√"+kq1);
                    edkq.setText((double)Math.round(Math.sqrt(kq1)*100000)/100000+"");
                    break;
                case R.id.btonechiaX:
                    double kq2 = Double.parseDouble(edkq.getText().toString());
                    //edbt.setText(edbt.getText()+"1/"+kq2);
                    edkq.setText((double) Math.round((1/kq2)*100000)/100000+"");
                    break;
                case R.id.btphantram:
                    double kq3 = Double.parseDouble(edkq.getText().toString())/100;
                    edkq.setText((double)Math.round(kq3*100000)/100000+"");
                    break;
                case R.id.btce:
                    edkq.setText("");

            }
        }catch (Exception ed){

        }

    }

}