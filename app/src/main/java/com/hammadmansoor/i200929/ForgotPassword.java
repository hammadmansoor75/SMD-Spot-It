package com.hammadmansoor.i200929;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        TextView goBack = findViewById(R.id.goBackClickable);
        goBack.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                Intent intent = new Intent(ForgotPassword.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}