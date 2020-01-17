package com.example.crimereport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class ComplainDatabasehelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "complain.db";
    public static final String TABLE_NAME = "complain";
    public static final String Col_5 = "Email_ID";
    public static final String ID = BaseColumns._ID;
    public static final String Col_1 = "Victim_name";
    public static final String Col_2 = "Police_station";
    public static final String Col_3 = "Crime_Type";
    public static final String Col_4 = "Describe_the_crime";


    public final String LOG = "Create table complain('" + this.ID + "' integer primary key AUTOINCREMENT, Email_ID varchar ,Victim_name text,Police_station text,Crime_Type varchar,Describe_the_crime text)";


    public ComplainDatabasehelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        Log.v("ComplainDatabasehelper", "YAhi HAi!");
        arg0.execSQL(LOG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean Register(String Victim_name, String Police_station, String Crime_type, String Describe_the_crime, String Email_ID) {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues co = new ContentValues();
        co.put(Col_1, Victim_name);
        co.put(Col_2, Police_station);
        co.put(Col_3, Crime_type);
        co.put(Col_4, Describe_the_crime);
        co.put(Col_5, Email_ID);


        long x = sq.insert("complain", null, co);
        sq.close();
        if (x == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor ViewData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select*from " + TABLE_NAME, null);
        return cursor;
    }
    public String check(String email_id) {
        SQLiteDatabase sq = this.getWritableDatabase();
        String x;
        Cursor cu = sq.rawQuery("select*from complain where Email_ID='" + email_id+"'", null);
        if (cu.getCount() < 1) {
            cu.close();
            return "user does not exist";

        }
        else {
            cu.moveToFirst();
            do {
                x = cu.getString(cu.getColumnIndex("Email_ID"));

            } while (cu.moveToNext());
            cu.close();
            sq.close();

            return x;
        }

    }



    }
