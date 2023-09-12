package com.hammadmansoor.i200929;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChatScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_screen);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_chat);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    startActivity(new Intent(ChatScreen.this, HomeScreen.class));
                    return true;
                } else if (itemId == R.id.action_search) {
                    startActivity(new Intent(ChatScreen.this, SearchScreen.class));
                    return true;
                } else if (itemId == R.id.action_profile) {
                    // Handle Profile item click
                    startActivity(new Intent(ChatScreen.this, ProfileScreen.class));
                    return true;
                } else if (itemId == R.id.action_chat) {
                    // Handle Profile item click
                    return true;
                }
                return false;
            }
        });
    }
}