package com.example.crud_basic_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View view) {
        Intent i=new Intent(MainActivity.this,insertactivity.class);
        startActivity(i);
    }

    public void update(View view) {
        Intent i=new Intent(MainActivity.this,updateactivity.class);
        startActivity(i);
    }

    public void delete(View view) {
        Intent i=new Intent(MainActivity.this,deleteactivity.class);
        startActivity(i);
    }

    public void view(View view) {
        Intent i=new Intent(MainActivity.this,viewactivity.class);
        startActivity(i);
        
    }
}