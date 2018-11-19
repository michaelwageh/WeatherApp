package com.example.michael.weatherapp;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class CairoActivity extends AppCompatActivity {

    private ListView listView;
    private List<Model> modelList;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cairo);

        listView = findViewById(R.id.lv_cairo);
        modelList = new ArrayList<>();



        cairoData();


    }


    private void cairoData(){

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading...");
        dialog.setMessage("Please wait...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.openweathermap.org/data/2.5/forecast?id=360630&appid=4c2cb68b9aedac875bee0ba6e1d8a8c3&units=metric";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        dialog.dismiss();

                        try {

                            JSONObject root = new JSONObject(response);
                            JSONObject city = root.getJSONObject("city");
                            String cityName = city.getString("name");
                            JSONArray list = root.getJSONArray("list");
                            for (int x = 0; x < list.length(); x++){

                                JSONObject rootOfArray = list.getJSONObject(x);
                                JSONObject main = rootOfArray.getJSONObject("main");
                                int temp = main.getInt("temp");
                                String date = rootOfArray.getString("dt_txt");

                                modelList.add(new Model(cityName , temp , date));

                            }

                            MyAdapter adapter = new MyAdapter(getApplicationContext() , modelList);

                            listView.setAdapter(adapter);

                            saveData(response);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            getSavedData();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                dialog.dismiss();
                Toast.makeText(CairoActivity.this, "Please connect to the internet and try again", Toast.LENGTH_SHORT).show();
                getSavedData();

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }

    private void saveData(String response){

        SharedPreferences sharedPreferences = getSharedPreferences("cairoData" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("dataOfCairo" , response);
        editor.apply();


    }


    private void getSavedData(){

        SharedPreferences sharedPreferences = getSharedPreferences("cairoData" , MODE_PRIVATE);
        String resp = sharedPreferences.getString("dataOfCairo" , "N/A");
        try {

            JSONObject root = new JSONObject(resp);
            JSONObject city = root.getJSONObject("city");
            String cityName = city.getString("name");
            JSONArray list = root.getJSONArray("list");
            for (int x = 0; x < list.length(); x++){

                JSONObject rootOfArray = list.getJSONObject(x);
                JSONObject main = rootOfArray.getJSONObject("main");
                int temp = main.getInt("temp");
                String date = rootOfArray.getString("dt_txt");

                modelList.add(new Model(cityName , temp , date));


            }

            MyAdapter adapter = new MyAdapter(getApplicationContext() , modelList);

            listView.setAdapter(adapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
