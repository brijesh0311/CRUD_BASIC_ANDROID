package com.example.crud_basic_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deleteactivity extends AppCompatActivity {

    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteactivity);

        id=findViewById(R.id.stu_id_del);
    }

    public void delete_id(View view) {

        DbHelper db=new DbHelper(this);
        boolean result=db.DeleteData(Integer.parseInt(id.getText().toString()));
        if (result==true)
            Toast.makeText(getApplicationContext(),"Record Deleted Successfully",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(),"Error ! Delete Function",Toast.LENGTH_LONG).show();
    }
}