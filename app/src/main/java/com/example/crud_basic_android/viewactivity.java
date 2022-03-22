package com.example.crud_basic_android;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class viewactivity extends AppCompatActivity {

    EditText id;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewactivity);

        id=findViewById(R.id.stu_id);
        tv=findViewById(R.id.tv);
    }

    public void search(View view) {
        DbHelper db2=new DbHelper(this);
        Cursor c=db2.searchData(Integer.parseInt(id.getText().toString()));
        if (c.moveToNext())
            tv.setText(c.getInt(0)+"\t"+c.getString(1)+"\t"+c.getInt(2)+"\t"+c.getString(3)+"\t"+c.getString(4)+"\t"+c.getString(5)+"\t"+c.getString(6)+"\t\n");

        else
            Toast.makeText(getApplicationContext(),"Error in find By ID ",Toast.LENGTH_SHORT).show();
    }

    public void viewall(View view) {

        DbHelper db3=new DbHelper(this);
        Cursor c=db3.ViewAllData();
        StringBuilder sb=new StringBuilder();

        int record=c.getCount();

        if (record==0){
            Toast.makeText(getApplicationContext(),"No Record Found",Toast.LENGTH_SHORT).show();
        }
        else{
            while (c.moveToNext()){
                sb.append(c.getInt(0)+"\t"+c.getString(1)+"\t"+c.getInt(2)+"\t"+c.getString(3)+"\t"+c.getString(4)+"\t"+c.getString(5)+"\t"+c.getString(6)+"\t\n");
            }
            tv.setText(sb);
        }

    }
}