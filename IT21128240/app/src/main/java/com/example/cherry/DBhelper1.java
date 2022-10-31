package com.example.cherry;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBhelper1 extends SQLiteOpenHelper{
    public static final String DBNAME = "Login.db";
    public static final String col1 = "weight";
    public static final String col2 = "height";
    public static final String col3 = "bmi";

    private Context context;

    public DBhelper1(@Nullable Context context) {
        super(context , DBNAME , null , 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase sdb){
        sdb.execSQL("create table users (id Integer primary key autoincrement, weight float, height float, bmi float  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int i, int i1) {

        sdb.execSQL("drop table if exists users");
    }
    public boolean insertData1(float weight){

        SQLiteDatabase sdb= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(col1, weight);
        long result =sdb.insert("users",null,values);
        if (result==-1) return false;
        else {

            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public boolean insertData2(float height){

        SQLiteDatabase sdb= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(col2, height);
        long result =sdb.insert("users",null,values);
        if (result==-1) return false;
        else {

            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

//    public boolean insertData3(int t){
//
//        SQLiteDatabase sdb= this.getWritableDatabase();
//        ContentValues values=new ContentValues();
//        values.put(col1, weight);
//        long result =sdb.insert("users",null,values);
//        if (result==-1) return false;
//        else {
//
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//    }


}

