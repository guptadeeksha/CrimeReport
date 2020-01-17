package com.example.crimereport;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    public String userName = "";
TextView t1,t2;
EditText e1,e2;
Databasehelper ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=findViewById(R.id.user);
        e2=findViewById(R.id.password);
        final Button Login = findViewById(R.id.login);
        ds=new Databasehelper(this);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String UserName = getUserName(e1);
                String s2 = e2.getText().toString();
                userName = UserName;
                SharedPreferences pref = getSharedPreferences("personal", MODE_PRIVATE);
                String user=pref.getString("username","No name defined");
                String pass=pref.getString("password","No name");
                String z = ds.login(UserName, s2);
                if (s2.equals(z)) {
                    Toast.makeText(getApplicationContext(), "Login succesful", Toast.LENGTH_LONG).show();
                    logging.onClick(Login);
                } else {
                    Toast.makeText(getApplicationContext(), "User not registered", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    public String getUserName(EditText e1){
        String mUserName = e1.getText().toString();
        return mUserName;
    }
    public void logging(View view) {
    }

    private View.OnClickListener logging= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1;
            intent1 =new Intent(login.this, Middle.class);
            startActivity(intent1);
        }
    };


}
