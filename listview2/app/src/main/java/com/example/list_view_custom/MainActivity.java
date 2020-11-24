package com.example.list_view_custom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.list_view_custom.Use.adapterDoiTuong;
import com.example.list_view_custom.Use.doiTuong;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText ed1  ,ed2 ;
    ListView listView;
    TextView tv1 , tv2 ;
    private static final int REQUEST_CODE= 101;
    CircleImageView imageViewDaidien;
    Uri imageUri;
    ArrayList<doiTuong> arrayList;
    ArrayList<String> listTieuDe;
    ArrayList<String> listConten;
    ArrayList<String> listImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewDaidien = findViewById(R.id.imageView);
        listView = findViewById(R.id.listview);
        btn1 = findViewById(R.id.btnOK_Title);

        ed1 = findViewById(R.id.inputTitle);
        ed2 = findViewById(R.id.input_conten);

        tv1 = findViewById(R.id.tvTitle);
        tv2 = findViewById(R.id.tv_conten);

        listTieuDe = new ArrayList<>();
        listConten = new ArrayList<>();
        listImage = new ArrayList<>();

        imageViewDaidien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpListView();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Tính năng này sẽ sớm hoàn thiện", Toast.LENGTH_SHORT).show();
                new AlertDialog.Builder(MainActivity.this).setTitle("Chọn Một Thao Tác ")
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listView.removeViewAt(i);
                                listTieuDe.remove(i);
                                listConten.remove(i);
                                listImage.remove(i);
                            }
                        }).setNeutralButton("Sửa Đổi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
                return false;
            }
        });
    }

    private void UpListView() {
        if(ed1.getText().toString().isEmpty()){
            Toast.makeText(this, "Bạn chưa nhập title cho danh sách", Toast.LENGTH_SHORT).show();
        }
        else if(ed2.getText().toString().isEmpty()){
            Toast.makeText(this, "Bạn chưa nhập nội dung conten", Toast.LENGTH_SHORT).show();
        }else if(imageUri == null ){
            Toast.makeText(this, "Ban chon hinh anh cho doi tuong ", Toast.LENGTH_SHORT).show();

        }else{
                String title = ed1.getText().toString();
                String conten  = ed2.getText().toString();
                arrayList = new ArrayList<>();

                listTieuDe.add(title);
                listConten.add(conten);
                listImage.add(imageUri.toString());
            //arrayList.add(new doiTuong(title, conten, imageUri.toString()));
                for(int i =0; i<listTieuDe.size(); i++){
                    arrayList.add(new doiTuong(listTieuDe.get(i).toString(), listConten.get(i).toString(), listImage.get(i).toString()));
                }
                adapterDoiTuong adapter = new adapterDoiTuong(MainActivity.this , R.layout.sign_list_view, arrayList);
                listView.setAdapter(adapter);
                ed2.setText("");
                ed1.setText("");
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== REQUEST_CODE && resultCode== RESULT_OK && data!= null){
            imageUri = data.getData();
            //Toast.makeText(this, ""+imageUri.toString(), Toast.LENGTH_SHORT).show();
            imageViewDaidien.setImageURI(imageUri);
        }
    }
}