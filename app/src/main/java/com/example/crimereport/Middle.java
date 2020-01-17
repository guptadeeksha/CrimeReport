package com.example.crimereport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Middle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.middle);

        Button Reg= findViewById(R.id.register);
        Reg.setOnClickListener(fnreg);

        Button Pro= findViewById(R.id.profile);
        Pro.setOnClickListener(fnprofile);


    }

    public void Middle (View view) {
    }

    private View.OnClickListener fnreg= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1= new Intent(Middle.this, Register.class);
            startActivity(intent1);
        }
    };

    private View.OnClickListener fnprofile= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1= new Intent(Middle.this, Profile.class);
            startActivity(intent1);
        }
    };


}
