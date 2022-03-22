package com.example.crud_basic_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class insertactivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    RadioGroup rg;
    Spinner sp;
    String ary[]={"Rajkot","Ahmedabad","Jamnagar"};
    CheckBox c1,c2,c3,c4;

    String name;
    String clg;

    int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertactivity);

        ed1=findViewById(R.id.stu_name);
        ed2=findViewById(R.id.stu_age);
        ed3=findViewById(R.id.stu_clg);
        rg=findViewById(R.id.group);
        sp=findViewById(R.id.spinner);
        c1=findViewById(R.id.cricket);
        c2=findViewById(R.id.swimming);
        c3=findViewById(R.id.hockey);
        c4=findViewById(R.id.badminton);

        ArrayAdapter<String> adpt=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ary);
        sp.setAdapter(adpt);


        //name=ed1.getText().toString();
        //age=Integer.parseInt(ed2.getText().toString());
        //clg=ed3.getText().toString();
    }

    public void insert(View view) {

        int id=rg.getCheckedRadioButtonId();
        RadioButton rd=findViewById(id);

        StringBuilder sb=new StringBuilder();
        if (c1.isChecked()){
            sb.append(c1.getText().toString()+" ");
        }
        if (c2.isChecked()){
            sb.append(c2.getText().toString()+" ");
        }
        if (c3.isChecked()){
            sb.append(c3.getText().toString()+" ");
        }
        if (c4.isChecked()){
            sb.append(c4.getText().toString()+" ");
        }



        //Toast.makeText(getApplicationContext(),"NAME = "+ed1.getText().toString()+" \n"+"AGE ="+Integer.parseInt(ed2.getText().toString()) +" \n"+"COLLEGE = "+ed3.getText().toString()+"\n "+"GENDER = "+rd.getText().toString()+" \n"+"CITY ="+sp.getSelectedItem().toString()+" \n"+"HOBBY ="+sb+"\n",Toast.LENGTH_LONG).show();

        DbHelper db=new DbHelper(this);
        boolean status=db.insertData(ed1.getText().toString(),Integer.parseInt(ed2.getText().toString()),ed3.getText().toString(),rd.getText().toString(),sb.toString(),sp.getSelectedItem().toString());

        if (status)
           Toast.makeText(getApplicationContext(),"Record Inserted Succefully",Toast.LENGTH_LONG).show();
        else
           Toast.makeText(getApplicationContext(),"Error in Inserted ",Toast.LENGTH_LONG).show();
    }
}