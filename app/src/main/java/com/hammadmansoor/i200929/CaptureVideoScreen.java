package com.hammadmansoor.i200929;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CaptureVideoScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_video_screen);

        ImageView cancel = findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CaptureVideoScreen.this,MessageScreen.class);
                startActivity(intent);
            }
        });


        TextView photo = findViewById(R.id.photo);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CaptureVideoScreen.this,CapturePhotoScreen.class);
                startActivity(intent);
            }
        });
    }
}