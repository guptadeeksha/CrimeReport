package com.example.crimereport;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class View1 extends AppCompatActivity{
ComplainDatabasehelper helper;
login l=new login();
    //Cursor cursor = parseEntries();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        helper= new ComplainDatabasehelper(this);

        displayEntries();
        Log.v("AKSHAY", "\n" + user);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//    }
    String user= l.userName;


    public void displayEntries(){

        SQLiteDatabase sb= helper.getWritableDatabase();

       // TextView ID = findViewById(R.id.ID);
        TextView vName = (TextView) findViewById(R.id.text_view_contacts);
//        TextView pName = findViewById(R.id.pol);
//        TextView c_type = findViewById(R.id.crimeType);
       // TextView de_sc = findViewById(R.id.desc);
        String[] Projection = {ComplainDatabasehelper.Col_1,
                ComplainDatabasehelper.Col_2,
                ComplainDatabasehelper.Col_3,
                ComplainDatabasehelper.Col_4};
        Cursor cursor = sb.query(ComplainDatabasehelper.TABLE_NAME, Projection, null, null, null, null, null);
       //Cursor cursor=sb.rawQuery("select*from complain where '"+ComplainDatabasehelper.Col_5 + "'='"+user+ "'",null);
        try {
            //int idIndex = cursor.getColumnIndex(ComplainDatabasehelper.ID);
            int victimName = cursor.getColumnIndex(ComplainDatabasehelper.Col_1);
            int policeStation = cursor.getColumnIndex(ComplainDatabasehelper.Col_2);
            int crimeType = cursor.getColumnIndex(ComplainDatabasehelper.Col_3);
            int desc = cursor.getColumnIndex(ComplainDatabasehelper.Col_4);

//            if(victimName<0){
//                Log.v("ERROR", "LESS THAN ZERO");
//            }else{
//                Log.v("CLOSE", "DB is close");
//            }
        while (cursor.moveToNext()){
          //  int CurrentId = cursor.getInt(idIndex);

            String CurrentVName = cursor.getString(victimName);
            String CurrentPoliceStation = cursor.getString(policeStation);
            String CurrentCrimeType = cursor.getString(crimeType);
            String CurrentDesc = cursor.getString(desc);

           // ID.setText(CurrentId);
            vName.append("\n" + CurrentVName + "---"
                    +CurrentPoliceStation + "---"
            + CurrentCrimeType + "---"
            + CurrentDesc);
//            pName.append(CurrentPoliceStation);
//            c_type.append(CurrentCrimeType);
//            de_sc.append(CurrentDesc);


//            Log.e("AKSHAY", "\n" + CurrentDesc);

        }


        }

        finally {


            sb.close();
            //cursor.close();

            //throw new IllegalArgumentException("Error in display:Akshay");

        }

    }
    public void View1(View view) {

    }

//    public Cursor parseEntries() {
//        SQLiteDatabase sb = helper.getReadableDatabase();
//        if (sb.isOpen()){
//
//        }
//
//        String[] Projection = {ComplainDatabasehelper.ID,
//                ComplainDatabasehelper.Col_1,
//                ComplainDatabasehelper.Col_2,
//                ComplainDatabasehelper.Col_3,
//                ComplainDatabasehelper.Col_4};
//
//
//      //  Cursor cursor = sb.query(ComplainDatabasehelper.TABLE_NAME, Projection, null, null, null, null, null);
//
//        return cursor;
//    }
}
