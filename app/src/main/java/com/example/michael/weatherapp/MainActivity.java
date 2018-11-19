package com.example.michael.weatherapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog dialogBuilder;
    private TextView tvCairo , tvCairoTemp , tvAlex , tvAlexTemp , tvAswan , tvAswanTemp , tvLuxor , tvLuxorTemp , tvMatruh , tvMatruhTemp;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;



    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextViews();

        sharedPreferences = getSharedPreferences("data" , MODE_PRIVATE);
        editor = sharedPreferences.edit();



        dialogBuilder = new ProgressDialog(MainActivity.this);
        dialogBuilder.setTitle("Loading...");
        dialogBuilder.setMessage("Please Wait...");
        dialogBuilder.setCanceledOnTouchOutside(false);
        dialogBuilder.show();

        cairoWeather();
        alexWeather();
        aswanWeather();
        luxorWeather();
        matruhWeather();



    }


    private void initTextViews(){

        tvCairo = findViewById(R.id.tv_cairo);
        tvCairoTemp = findViewById(R.id.tv_cairo_temp);
        tvAlex = findViewById(R.id.tv_alexandria);
        tvAlexTemp = findViewById(R.id.tv_alexandria_temp);
        tvAswan = findViewById(R.id.tv_aswan);
        tvAswanTemp = findViewById(R.id.tv_aswan_temp);
        tvLuxor = findViewById(R.id.tv_luxor);
        tvLuxorTemp = findViewById(R.id.tv_luxor_temp);
        tvMatruh = findViewById(R.id.tv_matruh);
        tvMatruhTemp = findViewById(R.id.tv_matruh_temp);

    }



    private void cairoWeather(){


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/weather?id=360630&appid=4c2cb68b9aedac875bee0ba6e1d8a8c3&units=metric";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        dialogBuilder.dismiss();

                        try {

                            JSONObject root = new JSONObject(response);
                            JSONObject main = root.getJSONObject("main");
                            String nameOfCity = root.getString("name");
                            int temp = main.getInt("temp");

                            tvCairo.setText(nameOfCity);
                            tvCairoTemp.setText(String.valueOf(temp + "c"));

                            editor.putString("cairo" , nameOfCity);
                            editor.putInt("cairoTemp" , temp);
                            editor.apply();


                        } catch (JSONException e) {

                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                dialogBuilder.dismiss();
                Toast.makeText(MainActivity.this, "You must connect to the internet and try again", Toast.LENGTH_LONG).show();

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }


    private void alexWeather(){


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/weather?id=361058&appid=4c2cb68b9aedac875bee0ba6e1d8a8c3&units=metric";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        dialogBuilder.dismiss();

                        try {

                            JSONObject root = new JSONObject(response);
                            JSONObject main = root.getJSONObject("main");
                            String nameOfCity = root.getString("name");
                            int temp = main.getInt("temp");
                            tvAlex.setText(nameOfCity);
                            tvAlexTemp.setText(String.valueOf(temp + "c"));
                            editor.putString("alex" , nameOfCity);
                            editor.putInt("alexTemp" , temp);
                            editor.apply();

                        } catch (JSONException e) {

                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);



    }


    private void aswanWeather(){


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/weather?id=359792&appid=4c2cb68b9aedac875bee0ba6e1d8a8c3&units=metric";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        dialogBuilder.dismiss();

                        try {

                            JSONObject root = new JSONObject(response);
                            JSONObject main = root.getJSONObject("main");
                            String nameOfCity = root.getString("name");
                            int temp = main.getInt("temp");
                            tvAswan.setText(nameOfCity);
                            tvAswanTemp.setText(String.valueOf(temp + "c"));
                            editor.putString("aswan" , nameOfCity);
                            editor.putInt("aswanTemp" , temp);
                            editor.apply();

                        } catch (JSONException e) {

                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);



    }


    private void luxorWeather(){


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/weather?id=360502&appid=4c2cb68b9aedac875bee0ba6e1d8a8c3&units=metric";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        dialogBuilder.dismiss();

                        try {

                            JSONObject root = new JSONObject(response);
                            JSONObject main = root.getJSONObject("main");
                            String nameOfCity = root.getString("name");
                            int temp = main.getInt("temp");
                            tvLuxor.setText(nameOfCity);
                            tvLuxorTemp.setText(String.valueOf(temp + "c"));
                            editor.putString("luxor" , nameOfCity);
                            editor.putInt("luxorTemp" , temp);
                            editor.apply();

                        } catch (JSONException e) {

                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);



    }


    private void matruhWeather(){


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/weather?id=352733&appid=4c2cb68b9aedac875bee0ba6e1d8a8c3&units=metric";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        dialogBuilder.dismiss();

                        try {

                            JSONObject root = new JSONObject(response);
                            JSONObject main = root.getJSONObject("main");
                            String nameOfCity = root.getString("name");
                            int temp = main.getInt("temp");
                            tvMatruh.setText(nameOfCity);
                            tvMatruhTemp.setText(String.valueOf(temp + "c"));
                            editor.putString("matruh" , nameOfCity);
                            editor.putInt("matruhTemp" , temp);
                            editor.apply();


                        } catch (JSONException e) {

                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);



    }


    private void getDataOffline(){

        sharedPreferences = getSharedPreferences("data" , MODE_PRIVATE);

        String cairo = sharedPreferences.getString("cairo" , "N/A");
        int cairoTemp = sharedPreferences.getInt("cairoTemp" , 0);
        String alex = sharedPreferences.getString("alex" , "N/A");
        int alexTemp = sharedPreferences.getInt("alexTemp" , 0);
        String aswan = sharedPreferences.getString("aswan" , "N/A");
        int aswanTemp = sharedPreferences.getInt("aswanTemp" , 0);
        String luxor = sharedPreferences.getString("luxor" , "N/A");
        int luxorTemp = sharedPreferences.getInt("luxorTemp" , 0);
        String matruh = sharedPreferences.getString("matruh" , "N/A");
        int matruhTemp = sharedPreferences.getInt("matruhTemp" , 0);

        tvCairo.setText(cairo);
        tvCairoTemp.setText(String.valueOf(cairoTemp + "c"));
        tvAlex.setText(alex);
        tvAlexTemp.setText(String.valueOf(alexTemp + "c"));
        tvAswan.setText(aswan);
        tvAswanTemp.setText(String.valueOf(aswanTemp + "c"));
        tvLuxor.setText(luxor);
        tvLuxorTemp.setText(String.valueOf(luxorTemp + "c"));
        tvMatruh.setText(matruh);
        tvMatruhTemp.setText(String.valueOf(matruhTemp + "c"));



    }


    @Override
    protected void onResume() {
        super.onResume();
        getDataOffline();
    }

    public void cairoDetails(View view) {
        startActivity(new Intent(this , CairoActivity.class));
    }

    public void alexDetails(View view) {
        startActivity(new Intent(this , AlexandriaActivity.class));
    }

    public void aswanDetails(View view) {
        startActivity(new Intent(this , AswanActivity.class));
    }

    public void luxorDetails(View view) {
        startActivity(new Intent(this , LuxorActivity.class));
    }

    public void matruhDetails(View view) {
        startActivity(new Intent(this , MatruhActivity.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu , menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_contact_us){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:miohy325i@gmail.com"));
            startActivity(Intent.createChooser(emailIntent, "Contact Us"));
        }

        return true;
    }
}
