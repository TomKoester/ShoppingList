package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private String username="Tom";
    private String password="1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void checkCredentials(View view) {
        EditText username = findViewById(R.id.etUsername);
        EditText password = findViewById(R.id.etPassword);
        if(check(username.getText().toString(),password.getText().toString())){
            Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
            String usernameMessage = username.getText().toString();
            intent.putExtra("username",usernameMessage);
            startActivity(intent);
        }else{
            TextView alertMessage = findViewById(R.id.twAlertMessage);
            alertMessage.setText("Das waren falsche Eingaben");
        }

    }
    public boolean check(String uname, String pwd){
        if(uname.equals(username) && pwd.equals(password)){
            return true;
        }
        return  false;
    }

}