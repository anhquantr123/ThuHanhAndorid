package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView testlistview ;
    Button btn_add , btn_huy;
    ArrayList<String>danhsach = null;
    ArrayAdapter<String> adapter = null;
    EditText edthanhvien;
    int change_pos = -1;
    int index_delete = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testlistview = findViewById(R.id.lvdanhsach);
        edthanhvien = findViewById(R.id.input_member);
        btn_add = findViewById(R.id.btnadd);
        btn_huy = findViewById(R.id.btn_huy);
        btn_huy.setVisibility(View.GONE);
        danhsach = new ArrayList<>();




        final ArrayAdapter adapter =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,danhsach);
        testlistview.setAdapter(adapter);

        CheckListview();

        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_add.setText("Thêm Thành Viên");
                btn_huy.setVisibility(View.GONE);
                edthanhvien.setText("");
            }
        });
        //
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn_add.getText().equals("Thêm Thành Viên")){
                    try {
                        String status = "ChuaTonTai";
                        String name = edthanhvien.getText().toString().trim();
                        if(!name.isEmpty()){
                            if(danhsach.size()>0){
                                for (int i= 0 ; i<danhsach.size(); i++){
                                    if(name.equals(danhsach.get(i))){
                                        status="TonTai";
                                        Toast.makeText(MainActivity.this, "Thành Viên Đã Tồn Tại", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            if(status.equals("ChuaTonTai")){
                                danhsach.add(name);
                                edthanhvien.setText("");
                                adapter.notifyDataSetChanged();
                            }
                        }

                    }catch (Exception ed){
                        Toast.makeText(MainActivity.this, "Bạn Chưa Nhập Thành Viên", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    String name_New = edthanhvien.getText().toString().trim();
                    if(name_New.equals(danhsach.get(change_pos))){
                        Toast.makeText(MainActivity.this, "Thành Viên Trùng Với Thành Viên Trước Đó", Toast.LENGTH_SHORT).show();
                    }else {
                        danhsach.set(change_pos,name_New);
                        adapter.notifyDataSetChanged();
                        edthanhvien.setText("");
                        btn_add.setText("Thêm Thành Viên");
                        btn_huy.setVisibility(View.GONE);
                    }
                }
            }
        });


        testlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Bạn Click vào thành viên  "+danhsach.get(i) , Toast.LENGTH_SHORT).show();
            }
        });

        testlistview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                  final int vitri  = i;

                new AlertDialog.Builder(MainActivity.this).setTitle("Chọn Một Hành Động")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                danhsach.remove(vitri);
                                //Toast.makeText(MainActivity.this, ""+vitri, Toast.LENGTH_SHORT).show();
                                if(vitri == change_pos){
                                    edthanhvien.setText("");
                                    btn_add.setText("Thêm Thành Viên");
                                    btn_huy.setVisibility(View.GONE);
                                }
                                CheckListview();
                                adapter.notifyDataSetChanged();
                            }
                        }).setNeutralButton("Sửa Đổi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edthanhvien.setText(danhsach.get(vitri));
                        btn_add.setText("Cập Nhật");
                        btn_huy.setVisibility(View.VISIBLE);
                        change_pos = vitri;
                        //Toast.makeText(MainActivity.this, ""+change_pos, Toast.LENGTH_SHORT).show();
                        CheckListview();
                    }
                }).show();
                return true;
            }
        });

    }

    private void CheckListview() {
        if (danhsach.size()<0){
            edthanhvien.setText("");
            btn_huy.setVisibility(View.GONE);
            btn_add.setText("Thêm Thành Viên");
        }
    }

}