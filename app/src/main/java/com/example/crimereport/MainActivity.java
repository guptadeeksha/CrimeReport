package com.example.crimereport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Login = findViewById(R.id.login);
        Login.setOnClickListener(logging);

        Button Signon=findViewById(R.id.sign);
        Signon.setOnClickListener(signup);

        Button Visitor = findViewById(R.id.visit);
        Visitor.setOnClickListener(fnvisit);

        Button SOS = findViewById(R.id.sos);
        SOS.setOnClickListener(btnsos);
    }

    private View.OnClickListener logging = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1 = new Intent(MainActivity.this, login.class);
            startActivity(intent1);
        }
    };

    private View.OnClickListener signup = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent2;
            intent2= new Intent(MainActivity.this , Signing.class);
            startActivity(intent2);
        }
    };

    private View.OnClickListener fnvisit = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent2;
            intent2= new Intent(MainActivity.this , visitor.class);
            startActivity(intent2);
        }
    };

    private View.OnClickListener btnsos = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent2;
            intent2= new Intent(MainActivity.this , emergency.class);
            startActivity(intent2);
        }
    };

    public void signup(View view) {
    }

    public void logging(View view) {
    }

    public void btnsos(View view) {
    }
}
