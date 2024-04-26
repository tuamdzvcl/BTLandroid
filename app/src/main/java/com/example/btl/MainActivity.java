package com.example.btl;

import static android.text.method.TextKeyListener.clear;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
<<<<<<< HEAD
    TextView txttest;
    EditText editmasv,edittensv,editquequan;
    Button btninsert,btnupdate,btndelete,btnsearch;
    ListView lv;
    ArrayList<String> SV = new ArrayList<>();
    public void addcontroler(){
=======
    TextView txttest, txtloi;
    EditText editmasv, edittensv, editquequan;
    Button btninsert, btnupdate, btndelete, btnsearch;
    ListView lvsinh;
    ArrayList<SinhVien> SV;
    SinhVienAdepter adepter;

    //int vitri = -1;
    public void addcontroler() {
>>>>>>> 04db00239d180160bafa6a4daf0acd5898a3fd93

        editmasv = findViewById(R.id.edtmasv);
        edittensv = findViewById(R.id.edttensv);
        editquequan = findViewById(R.id.edtquequan);
        btninsert = findViewById(R.id.btninsert);
        btndelete = findViewById(R.id.btndelete);
        btnupdate = findViewById(R.id.btnUpdate);
        btnsearch = findViewById(R.id.btnsearch);
        //lv = findViewById(R.id.lv);
        txttest = findViewById(R.id.txtTest);
        txtloi = findViewById(R.id.txtloi);
        SV = new ArrayList<>();

    }

    ;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        addcontroler();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 9201f5baef0c4f540d87dcd7f1dd0c8be046f08e
        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        //db.execSQL("CREATE TABLE tblQLSV(masv text Primary key,name text,quequan text );");
        loaddanhsach();
        try {


lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = SV.get(position);

        // Tách dòng dữ liệu thành các phần riêng biệt (masv, tensv, quequan)
        String[] parts = selectedItem.split("-");

        // Thiết lập giá trị cho từng EditText tương ứng
        editmasv.setText(parts[0]); // Giá trị masv
        edittensv.setText(parts[1]); // Giá trị tensv
        editquequan.setText(parts[2]); // Giá trị quequan
    }
});}
        catch (Exception e)
        {
            txttest.setText("loi" +e);
        }
        db.close();
=======
        loaddanhsach();
>>>>>>> 04db00239d180160bafa6a4daf0acd5898a3fd93
    }

    private void loaddanhsach() {

        lvsinh =(ListView) findViewById(R.id.lv);
        SV = new ArrayList<>();
        SV.add(new SinhVien("6667458","tuấn anh","Hà Nội",R.drawable.ip));
        //db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanLySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 9201f5baef0c4f540d87dcd7f1dd0c8be046f08e
        SV.clear();
        //db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        //ArrayList<String> SV = new ArrayList<>();
        Cursor c1 = db.rawQuery("select * from tblQLSV",null);
        if(c1.moveToFirst())
            do
            {
                String masv = c1.getString(0);
                String tensv = c1.getString(1);
                String quequan = c1.getString(2);
                SV.add(masv +"-"+tensv+"-"+quequan);
=======
    }
}
        /* loaddanhsach();

        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        //db.execSQL("CREATE TABLE tblQLSV(masv text Primary key,name text,quequan text );");
>>>>>>> 04db00239d180160bafa6a4daf0acd5898a3fd93

      try {

          lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  //vitri = position;
                  SinhVien selectedItem = SV.get(position);


                  String[] parts = selectedItem.split("-");


                  editmasv.setText(parts[0]);
                  edittensv.setText(parts[1]);
                  editquequan.setText(parts[2]);
              }
          });
      }catch (SQLiteException e)
      {
          txtloi.setText("lõi" + e);
      }
        db.close();

    }

    private void Anhxa() {

    }

    private void loaddanhsach() {

        SV.clear();
        try {
            //db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien", null, SQLiteDatabase.CREATE_IF_NECESSARY);
            //ArrayList<String> SV = new ArrayList<>();
            Cursor c1 = db.rawQuery("select * from tblQLSV", null);
            if (c1.moveToFirst())
                do {
                    String masv = c1.getString(0);
                    String tensv = c1.getString(1);
                    String quequan = c1.getString(2);
                    //SV.add(masv + "-" + tensv + "-" + quequan);

                } while (c1.moveToNext());
            c1.close();
            //ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, SV);
            //lv.setAdapter(adapter);


        } catch (SQLiteException e)
        {
            txtloi.setText("loi "+ e);
        }
    }

    public void insert(View view) {
        String masv = editmasv.getText().toString();
        String tensv = edittensv.getText().toString();
        String quequan = editquequan.getText().toString();
        String msg = "";
        String msv = new String(masv);
        String tsv = new String(tensv);
        String qq = new String(quequan);
<<<<<<< HEAD
        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        if(msv.equals("")||tsv.equals("")||qq.equals(""))
        {
            msg = "Hãy nhập đầy đủ thông tin ";
        }
        else
        {
=======
        try {
            if (msv.equals("") || tsv.equals("") || qq.equals("")) {
                msg = "Hãy nhập đầy đủ thông tin ";
            }
            else
            {
               db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
                db.execSQL("INSERT INTO tblQLSV(masv,name,quequan)values('" + msv + "','" + tsv + "','" + qq + "');");

                msg = "Thêm thành công  " + "-" + msv + "-" + tsv + "-" + qq;

                clear();
                loaddanhsach();

            }
        }
        catch (SQLiteException e)
        {
<<<<<<< HEAD
>>>>>>> 9201f5baef0c4f540d87dcd7f1dd0c8be046f08e
            db.execSQL("INSERT INTO tblQLSV(masv,name,quequan)values('"+msv+"','"+tsv+"','"+qq+"');");
            msg = "Thêm thành công  "+"-"+msv+"-"+tsv+"-"+qq;
            clear();
=======

            txtloi.setText("loi " + e);
>>>>>>> 04db00239d180160bafa6a4daf0acd5898a3fd93
        }
        Cursor c1 = db.rawQuery("select * from tblQLSV", null);
        int thetoal = c1.getCount();
        txttest.setText("so ban ghi la " + thetoal);
        loaddanhsach();
        db.close();
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 9201f5baef0c4f540d87dcd7f1dd0c8be046f08e

        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
=======
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
>>>>>>> 04db00239d180160bafa6a4daf0acd5898a3fd93
    }


    private void clear() {
        editmasv.setText("");
        edittensv.setText("");
        editquequan.setText("");

    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 9201f5baef0c4f540d87dcd7f1dd0c8be046f08e
    public void delete(View view) {
        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);

        String masv =editmasv.getText().toString();
        String tensv = edittensv.getText().toString();
        String quequan = editquequan.getText().toString();

        try {
            db.delete("tblQLSV","masv=?",new String[]{masv});
            loaddanhsach();
            clear();
            Toast.makeText(MainActivity.this, "Xóa  thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Lỗi: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        db.close();

    }

    public void update(View view) {

        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);

        String masv =editmasv.getText().toString();
        String tensv = edittensv.getText().toString();
        String quequan = editquequan.getText().toString();
        ContentValues values = new ContentValues();

        values.put("name", tensv);
        values.put("quequan" ,quequan);
        try {
            db.update("tblQLSV",values,"masv=?",new String[]{masv});
            loaddanhsach();
            Toast.makeText(MainActivity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Lỗi: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
<<<<<<< HEAD
=======
=======
    public void search(View view) {
       String masv = editmasv.getText().toString();
       String tensv = edittensv.getText().toString();
       if(masv!=""&& tensv.equals("")) {
           timkiemtheomasv(masv);
       }
    }

    private void timkiemtheomasv(String masv) {

        try {
            db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien", null, SQLiteDatabase.CREATE_IF_NECESSARY);

            Cursor c1 = db.rawQuery("SELECT * FROM tblQLSV WHERE masv = ?", new String[]{masv});

            // Kiểm tra xem có dữ liệu trả về không
            if (c1 != null && c1.moveToFirst()) {
                SV.clear();
                do {
                    String name = c1.getString(1);
                    String quequan = c1.getString(2);
                    SV.add(name + "-" + quequan);
                }while (c1.moveToNext());
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, SV);
                lv.setAdapter(adapter);


            } else {
                Toast.makeText(MainActivity.this, "Không tìm thấy sinh viên có mã " + masv, Toast.LENGTH_SHORT).show();
            }
            if (c1 != null) {
                c1.close();
            }
        } catch (Exception e) {
            txtloi.setText("Lỗi: " + e);
        }
        if (db != null) {
            db.close();
        }
    }

    public void delete(View view) {
        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String msv = editmasv.getText().toString();
        try
        {
            db.delete("tblQLSV","masv=?",new String[]{msv});
            loaddanhsach();
            Toast.makeText(MainActivity.this,"xóa thành công ",Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            txtloi.setText("lỗi"+ e);

        }
        clear();
    }
    public void update(View view) {
        try {
        db = SQLiteDatabase.openDatabase("data/data/com.example.btl/QuanlySinhVien",null,SQLiteDatabase.CREATE_IF_NECESSARY);
        String masv= editmasv.getText().toString();
        String tensv = edittensv.getText().toString();
        String quequan = editquequan.getText().toString();
            ContentValues values = new ContentValues();
            values.put("name", tensv);
            values.put("quequan", quequan);


            db.update("tblQLSV",values,"masv =?",new String[]{masv});

        Toast.makeText(MainActivity.this,"Sủa thành công ",Toast.LENGTH_SHORT).show();
    }
        catch (Exception e)
    {
        txtloi.setText( " " + e);
    }
        loaddanhsach();
        clear();
    }


>>>>>>> 04db00239d180160bafa6a4daf0acd5898a3fd93
>>>>>>> 9201f5baef0c4f540d87dcd7f1dd0c8be046f08e
}

*/