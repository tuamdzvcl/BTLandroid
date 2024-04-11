package com.example.btl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

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

    };

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        addcontroler();
        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        db.execSQL("CREATE TABLE tblQLSV(masv text Primary key,name text,quequan text );");

        Cursor c1 = db.rawQuery("select * from tblQLSV",null);
        


        db.close();
    }

    public void insert(View view) {
        String masv = editmasv.getText().toString();
        String tensv = edittensv.getText().toString();
        String quequan = editquequan.getText().toString();
        String msv = new String(masv);
        String tsv = new String(tensv);
        String qq = new String(quequan);

        Toast.makeText(MainActivity.this,msv+"-"+tsv+"-"+qq,Toast.LENGTH_SHORT).show();
    }
}
