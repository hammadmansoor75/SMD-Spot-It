package com.hammadmansoor.i200929;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {


    EditText nameEditText, emailEditText, passwordEditText, phoneNumberEditText,
            countryEditText, cityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        phoneNumberEditText = findViewById(R.id.contactNumber);
        countryEditText = findViewById(R.id.country);
        cityEditText = findViewById(R.id.city);
        Button signUpButton = findViewById(R.id.signupButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get data from your UI elements
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String phoneNumber = phoneNumberEditText.getText().toString().trim();
                String country = countryEditText.getText().toString().trim();
                String city = cityEditText.getText().toString().trim();
                UniqueUserIdGenerator u  = new UniqueUserIdGenerator();
                String userId = String.valueOf(u.generateID());

                // Execute AsyncTask
                new SignUpTask().execute(name, email, password, phoneNumber, country, city, userId);
            }
        });
    }

    private class SignUpTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String name = params[0];
            String email = params[1];
            String password = params[2];
            String phoneNumber = params[3];
            String country = params[4];
            String city = params[5];
            String userId = params[6];

            // Make HTTP request using Volley
            RequestQueue queue = Volley.newRequestQueue(Registration.this);
            String url = "http://10.0.2.2/assignment3/Authentication/signup.php"; // Replace with your actual URL

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Handle the response from the server
                            Toast.makeText(Registration.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {


                @Override
                public void onErrorResponse(VolleyError error) {
                    // Handle error
                    Toast.makeText(Registration.this, "Error in network request", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    // Parameters to send to the PHP script
                    Map<String, String> params = new HashMap<>();
                    params.put("name", name);
                    params.put("email", email);
                    params.put("password", password);
                    params.put("phoneNumber", phoneNumber);
                    params.put("country", country);
                    params.put("city", city);
                    params.put("UserId", userId);
                    return params;
                }
            };

            // Add the request to the RequestQueue.
            queue.add(stringRequest);

            return null;
        }
    }
}