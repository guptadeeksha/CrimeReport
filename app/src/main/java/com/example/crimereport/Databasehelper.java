package com.example.crimereport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DB_NAME="CrimeReport.db";
    public static final String TABLE_NAME="users";
    public static final String Col_2="Email_ID";
    public static final String Col_3="Password";
    public static final String Col_4="Name";


    // package declaration left out, use your application package


    public final String LOG = "Create table users(Email_ID varchar primary key ,Password varchar,Name text)";
            public Databasehelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        arg0.execSQL(LOG);
        //arg0.execSQL(LOG2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean Register (String name,String email,String password){
        SQLiteDatabase sq =this.getWritableDatabase();
        ContentValues co=new ContentValues();
        co.put(Col_4,name);
        co.put(Col_2,email);
        co.put(Col_3,password);

        long x=sq.insert("users",null,co);
        sq.close();
        if(x==-1) {
            return false;
        }
        else{
            return true;
        }
    }
    public String login(String email_id,String up){
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cu=sq.rawQuery("select*from users where Email_ID='"+email_id+"'and Password='"+up+"'",null);
        if(cu.getCount()<1){
            cu.close();
            return "user not exist";

        }

        //Log.v(LOG,Integer.toString(cu.getColumnIndex("Password")));
        cu.moveToFirst();
        String x=cu.getString(cu.getColumnIndex("Password"));
        cu.close();
        sq.close();
        return x;
    }

    }

