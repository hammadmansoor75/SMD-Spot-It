package com.hammadmansoor.i200929;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MessageScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_screen);


        ImageView arrowBack = findViewById(R.id.backMessageScreen);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageScreen.this,ChatScreen.class);
                startActivity(intent);
            }
        });


        ImageView cameraIcon = findViewById(R.id.cameraIcon);

        cameraIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageScreen.this,CapturePhotoScreen.class);
                startActivity(intent);
            }
        });

        ImageView videoIcon = findViewById(R.id.videoIcon);

        videoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageScreen.this,VideoCallScreen.class);
                startActivity(intent);
            }
        });

        ImageView audioIcon = findViewById(R.id.audioIcon);

        audioIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageScreen.this,PhoneCallScreen.class);
                startActivity(intent);
            }
        });
    }

}