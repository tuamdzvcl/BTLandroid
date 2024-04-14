package com.example.btl;

import static android.text.method.TextKeyListener.clear;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.SQLData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txttest;
    EditText editmasv,edittensv,editquequan;
    Button btninsert,btnupdate,btndelete,btnsearch;
    ListView lv;
    public void addcontroler(){

        editmasv = findViewById(R.id.edtmasv);
        edittensv = findViewById(R.id.edttensv);
        editquequan = findViewById(R.id.edtquequan);
        btninsert = findViewById(R.id.btninsert);
        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnUpdate);
        btnsearch = findViewById(R.id.btnsearch);
        lv = findViewById(R.id.lv);
        txttest= findViewById(R.id.txtTest);
    };

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        addcontroler();
        loaddanhsach();
        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
       // db.execSQL("CREATE TABLE tblQLSV(masv text Primary key,name text,quequan text );");

        db.close();
    }

    private void loaddanhsach() {



        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        ArrayList<String> SV = new ArrayList<>();
        Cursor c1 = db.rawQuery("select * from tblQLSV",null);
        if(c1.moveToFirst())
            do
            {
                String masv = c1.getString(0);
                String tensv = c1.getString(1);
                String quequan = c1.getString(2);
                SV.add(masv +"-"+tensv+"-"+quequan);

            }while (c1.moveToNext());
        c1.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,SV);
        lv.setAdapter(adapter);
        db.close();
    }

    public void insert(View view) {
        String masv = editmasv.getText().toString();
        String tensv = edittensv.getText().toString();
        String quequan = editquequan.getText().toString();
        String msg = "";
        String msv = new String(masv);
        String tsv = new String(tensv);
        String qq = new String(quequan);
        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        if(msv.equals("")||tsv.equals("")||qq.equals(""))
        {
            msg = "Hãy nhập đầy đủ thông tin ";
        }
        else
        {

            db.execSQL("INSERT INTO tblQLSV(masv,name,quequan)values('"+msv+"','"+tsv+"','"+qq+"');");

            msg = "Thêm thành công  "+"-"+msv+"-"+tsv+"-"+qq;

            clear();
        }
        Cursor c1 = db.rawQuery("select * from tblQLSV",null);
        int thetoal = c1.getCount();
        txttest.setText("so ban ghi la " + thetoal);
        db.close();
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    private void clear() {
        editmasv.setText("");
        edittensv.setText("");
        editquequan.setText("");

    }
}
