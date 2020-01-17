package com.example.crimereport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signing extends AppCompatActivity {
    EditText e1,e2,e3;
    Button Signup;
    Databasehelper ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        e1=findViewById(R.id.name);
        e2=findViewById(R.id.username);
        e3=findViewById((R.id.password));
        Signup=findViewById(R.id.sign);
        ds=new Databasehelper(this);
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = getSharedPreferences("personal", MODE_PRIVATE).edit();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s1 = e1.getText().toString();
                boolean z = false;
                z = ds.Register(s1, s2, s3);
                if (z == true) {
                    Toast.makeText(getApplicationContext(), "User Register", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "User not register", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    public void Signing(View view) {
    }

    private View.OnClickListener signup = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1= new Intent(Signing.this, login.class);
            startActivity(intent1);
        }
    };

    public void signup(View view) {
    }
}
