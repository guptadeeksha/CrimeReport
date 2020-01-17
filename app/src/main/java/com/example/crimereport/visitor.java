package com.example.crimereport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class visitor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visitor);

        Button Crime= findViewById(R.id.crime);
        Crime.setOnClickListener(types);

        Button want= findViewById(R.id.most);
        want.setOnClickListener(fnwant);
    }

    public void visitor(View view) {
    }

    private View.OnClickListener types= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1=new Intent(visitor.this, Types.class);
            startActivity(intent1);
        }
    };

    private View.OnClickListener fnwant = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1=new Intent(visitor.this,Wanted.class);
            startActivity(intent1);
        }
    };


    public void crimetypes(View view) {
    }
}
