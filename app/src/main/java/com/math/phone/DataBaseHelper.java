package com.math.phone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME="Contact.db";
    private static String  TABLE_NAME="Contact_list";

    public static String  COL_NAME="Name";
    public static String  COL_ID="Id";
    public static String  COL_WORK="Work";
    public static String  COL_PHONE="Phone";
    public static String  COL_EMAIL="Email";
    public static String  COL_ADDRESS="Address";
    public static String  COL_NICK="Nick";
    public static String  COL_RELATION="Relation";
    private static int VERSION=1;
    private static String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"( Id INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT NOT NULL,Work TEXT ,Phone TEXT NOT NULL,Email TEXT , Address TEXT ,Nick TEXT ,Relation TEXT )";


    private static String DELETE_ITEM = "DELETE FROM "+TABLE_NAME+" WHERE Id="+COL_ID;






    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public  Long insertData(String name,String work,String phone,String email,String address,String nick,String relation){
        ContentValues values=new ContentValues();
        values.put(COL_NAME,name);
        values.put(COL_WORK,work);
        values.put(COL_PHONE,phone);
        values.put(COL_EMAIL,email);
        values.put(COL_NICK,nick);
        values.put(COL_ADDRESS,address);
        values.put(COL_RELATION,relation);

        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Long id=sqLiteDatabase.insert(TABLE_NAME,null,values);

return id;

    }

    public Cursor showData(){

        String showInfo="SELECT * FROM "+TABLE_NAME;

        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
       Cursor cursor=  sqLiteDatabase.rawQuery(showInfo,null);
return  cursor;



    }



}
