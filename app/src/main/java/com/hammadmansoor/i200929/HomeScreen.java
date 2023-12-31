package com.hammadmansoor.i200929;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    // Handle Home item click
                    return true;
                } else if (itemId == R.id.action_search) {
                    startActivity(new Intent(HomeScreen.this, SearchScreen.class));
                    return true;
                } else if (itemId == R.id.action_profile) {
                    // Handle Profile item click
                    startActivity(new Intent(HomeScreen.this, ProfileScreen.class));
                    return true;
                } else if (itemId == R.id.action_chat) {
                    // Handle Profile item click
                    startActivity(new Intent(HomeScreen.this, ChatScreen.class));
                    return true;
                }
                else if (itemId == R.id.action_add) {
                    // Handle Profile item click
                    startActivity(new Intent(HomeScreen.this,AddItemScreen.class));
                    return true;
                }
                return false;
            }
        });


        CardView item = findViewById(R.id.item);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this,ItemDetailsScreen.class));
            }
        });
    }
}