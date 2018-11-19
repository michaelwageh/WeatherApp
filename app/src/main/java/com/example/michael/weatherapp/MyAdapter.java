package com.example.michael.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Model> {


    private Context ctx;
    private List<Model> modelList;


    public MyAdapter(Context context, List<Model> models) {
        super(context , R.layout.custom_list_view , models);
        this.ctx = context;
        this.modelList = models;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Model model = modelList.get(position);
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.custom_list_view , parent , false);
        TextView tvCity = view.findViewById(R.id.tv_cities);
        TextView tvTemp = view.findViewById(R.id.tv_temps);
        TextView tvDates = view.findViewById(R.id.tv_dates);

        tvCity.setText(model.getCityName());
        tvTemp.setText(String.valueOf(model.getTempOfCity() + "c"));
        tvDates.setText(model.getDateOfCity());


        return view;
    }
}
