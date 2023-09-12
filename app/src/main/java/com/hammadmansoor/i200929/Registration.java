package com.hammadmansoor.i200929;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button signup = findViewById(R.id.signupButton);
        signup.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                Intent intent = new Intent(Registration.this, EmailVerification.class);
                startActivity(intent);
            }
        });

        TextView login = findViewById(R.id.loginClickable);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                Intent intent = new Intent(Registration.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}