package com.example.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Nutrition.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "food";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "meal";
    private static final String COLUMN_FOOD = "food";
    private static final String COLUMN_QUANTITY = "quantity";
    private static final String COLUMN_CALORIES = "Calories";

    DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_FOOD + " TEXT, " +
                COLUMN_QUANTITY + " TEXT, " +
                COLUMN_CALORIES + " INTEGER);";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add meals to the database
    void addMeal(String meal, String food, String quantity, int calories){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        
        cv.put(COLUMN_TITLE, meal);
        cv.put(COLUMN_FOOD, food);
        cv.put(COLUMN_QUANTITY, quantity);
        cv.put(COLUMN_CALORIES, calories);
        
        long result = db.insert(TABLE_NAME, null, cv);
        
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    //read all data from database
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
           cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    //update data in the database
    void updateData(String row_id, String meal, String food_name, String quantity, String calories){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, meal);
        cv.put(COLUMN_FOOD, food_name);
        cv.put(COLUMN_QUANTITY, quantity);
        cv.put(COLUMN_CALORIES, calories);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully updated", Toast.LENGTH_SHORT).show();
        }
    }

    //delete one record from database
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});

        if(result == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show();
        }
    }

    //delete all data from database
    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
