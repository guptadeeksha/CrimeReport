package com.example.crimereport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
TextView t1,t2,t3,t4,t5;
Button Sub;
ComplainDatabasehelper ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.police);
        t3=findViewById(R.id.crime);
        t4=findViewById(R.id.desc);
        t5=findViewById(R.id.email);
        Sub = findViewById(R.id.submit);
        ds=new ComplainDatabasehelper(this);
        Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences.Editor edit = getSharedPreferences("personal", MODE_PRIVATE).edit();
                String s1=t1.getText().toString();
                String s2=t2.getText().toString();
                String s3=t3.getText().toString();
                String s4=t4.getText().toString();
                String s5=t5.getText().toString();
                boolean z=false;
                 z=ds.Register(s1,s2, s3, s4, s5);
                 if(z==true) {
                     Toast.makeText(getApplicationContext(), "User Register", Toast.LENGTH_LONG).show();
                     fnsubmit.onClick(Sub);


                 }
                 else{
                     Toast.makeText(getApplicationContext(),"User not registered",Toast.LENGTH_LONG).show();
                 }

            }
        });
    }

    public void Register(View view) {
    }

    private View.OnClickListener fnsubmit= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;

            intent1 =new Intent(Register.this, Middle.class);
            startActivity(intent1);
        }
    };
}
