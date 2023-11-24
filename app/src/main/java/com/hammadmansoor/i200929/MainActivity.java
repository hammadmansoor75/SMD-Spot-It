package com.hammadmansoor.i200929;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);

        Button login = findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Get email and password from your UI elements
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();


                // Execute AsyncTask
                new LoginTask().execute(email, password);
            }
        });


    }
    public void Signup(View view){
        startActivity(new Intent(MainActivity.this, Registration.class));

    }
    private class LoginTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String email = params[0];
            String password = params[1];

            // Make HTTP request using Volley
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            String url = "http://10.0.2.2/assignment3/Authentication/login.php";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Handle the response from the server
                            try {
                                JSONObject jsonResponse = new JSONObject(response);

                                if (jsonResponse.getBoolean("success")) {
                                    // Login successful
                                    Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                                    startActivity(intent);
                                } else {
                                    // Login failed
                                    Toast.makeText(MainActivity.this, jsonResponse.getString("message"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(MainActivity.this, "Error parsing JSON response", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Handle error
                    Toast.makeText(MainActivity.this, "Error in network request", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected HashMap<String, String> getParams() {
                    // Parameters to send to the PHP script
                    HashMap<String, String> params = new HashMap<>();
                    params.put("email", email);
                    params.put("password", password);
                    return params;
                }
            };

            // Add the request to the RequestQueue.
            queue.add(stringRequest);

            return null;
        }
    }
}
