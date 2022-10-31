package com.example.cherry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBhelper  extends SQLiteOpenHelper {

    public static final String DBNAME="login.db";
    public static final String col1="goal";
    public static final String col2 = "volume";
    public static final String col3 = "cust";
    private Context context;
    public DBhelper(@Nullable Context context) {
        super(context , DBNAME , null , 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {

        sdb.execSQL("create table users (id Integer primary key autoincrement, goal integer  )");
        //sdb
    }



    @Override
    public void onUpgrade(SQLiteDatabase sdb, int i, int i1) {

        sdb.execSQL("drop table if exists users");
    }

    public boolean insertData(int goal){

        SQLiteDatabase sdb= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(col1, goal);
        long result =sdb.insert("users",null,values);
        if (result==-1) return false;
        else {

            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public boolean insertCust(int cust){

        SQLiteDatabase sdb= this.getWritableDatabase();
        sdb.execSQL("ALTER table users add cust integer");
        ContentValues values=new ContentValues();
        values.put(col3, cust);
        long result =sdb.insert("users",null,values);
        if (result==-1) return false;
        else {

            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            return true;
        }
    }


    public boolean insertVolume(int volume){

        SQLiteDatabase sdb= this.getWritableDatabase();
        sdb.execSQL("ALTER table users add volume integer");
        ContentValues values=new ContentValues();
        values.put(col2, volume);
        long result =sdb.insert("users",null,values);
        if (result==-1){
            return false;
        }
        else {

            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public boolean insertVolume1(int volume){

        SQLiteDatabase sdb= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(col2, volume);
        long result =sdb.insert("users",null,values);
        if (result==-1){
            return false;
        }
        else {

            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public Boolean checkemail(String email){
        SQLiteDatabase sdb=this.getWritableDatabase();
        Cursor cursor= sdb.rawQuery("select * from users where email=?",new String[] {email});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkemailpassword(String email , String password){
        SQLiteDatabase sdb=this.getWritableDatabase();
        Cursor cursor= sdb.rawQuery("select * from users where email=? and password=?",new String[] {email ,password});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    Cursor readData(){
        String query = "SELECT * FROM " + "users";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

}


