package com.example.crud_basic_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Spinner;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "Student", null,3);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE STUDENT_DATA(ID INTEGER  PRIMARY KEY,NAME TEXT,AGE INTEGER,COLLEGE TEXT,GENDER TEXT,HOBBY TEXT,CITY TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS STUDENT_DATA");
        onCreate(sqLiteDatabase);

    }

    boolean insertData(String name, int age, String clg, String gender, String hobby, String city){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("NAME",name);
        cv.put("AGE",age);
        cv.put("COLLEGE",clg);
        cv.put("GENDER",gender);
        cv.put("HOBBY",hobby);
        cv.put("CITY",city);
        long status=db.insert("STUDENT_DATA",null,cv);


        if (status==-1)
            return false;
        else
            return true;
    }

    Cursor searchData(int id){



        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.query("STUDENT_DATA",null,"ID=?",new String[]{String.valueOf(id)},null,null,null);
        return  cursor;

    }
    Cursor ViewAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.query("STUDENT_DATA",null,null,null,null,null,null);
        return cursor;
    }

    boolean DeleteData(int id){

        SQLiteDatabase db=this.getWritableDatabase();
        int result=db.delete("STUDENT_DATA","ID=?",new String[]{String.valueOf(id)});
        if (result==0){
             return false;
        }
        else
            return true;
    }

    boolean UpdateDa(int id, String name, int age,String clg,String gender, String hobby, String city){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("NAME",name);
        cv.put("AGE",age);
        cv.put("COLLEGE",clg);
        cv.put("GENDER",gender);
        cv.put("HOBBY",hobby);
        cv.put("CITY",city);

        int result=db.update("STUDENT_DATA",cv,"ID=?",new String[]{String.valueOf(id)});

        if (result==0){
            return false;
        }
        else
            return  true;

    }


}
