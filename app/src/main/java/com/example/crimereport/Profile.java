package com.example.crimereport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        Button Reg = findViewById(R.id.reg);
        Reg.setOnClickListener(fnreg);

        Button Viewcom= findViewById(R.id.view);
        Viewcom.setOnClickListener(fnview);
    }

    public void Profile(View view) {
    }

    private View.OnClickListener fnreg= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1 =new Intent(Profile.this, Register.class);
            startActivity(intent1);
        }
    };

    private View.OnClickListener fnview= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1= new Intent(Profile.this, View1.class);
            startActivity(intent1);
        }
    };
}
