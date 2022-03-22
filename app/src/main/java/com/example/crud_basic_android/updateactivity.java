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
import android.widget.Toast;

public class updateactivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
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
        setContentView(R.layout.activity_updateactivity);

        ed1=findViewById(R.id.stu_id_upd);
        ed2=findViewById(R.id.stu_name_upd);
        ed3=findViewById(R.id.stu_age_upd);
        ed4=findViewById(R.id.stu_clg_upd);

        rg=findViewById(R.id.group_upd);
        sp=findViewById(R.id.spinner_upd);
        c1=findViewById(R.id.cricket_upd);
        c2=findViewById(R.id.swimming_upd);
        c3=findViewById(R.id.hockey_upd);
        c4=findViewById(R.id.badminton_upd);

        ArrayAdapter<String> adpt=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ary);
        sp.setAdapter(adpt);

    }

    public void updateData(View view) {

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

        DbHelper db=new DbHelper(this);
        //Toast.makeText(getApplicationContext(),"Record Updated",Toast.LENGTH_LONG).show();
        boolean result=db.UpdateDa ( Integer.parseInt(ed1.getText().toString()) , ed2.getText().toString() , Integer.parseInt(ed3.getText().toString()), ed4.getText().toString(),rd.getText().toString(),sb.toString(),sp.getSelectedItem().toString());
        if (result==true){
            Toast.makeText(getApplicationContext(),"Record Updated",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Error in Update ", Toast.LENGTH_LONG).show();
        }
    }
}