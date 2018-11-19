package com.example.michael.weatherapp;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RemoteViews;


/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link WeatherWidgetConfigureActivity WeatherWidgetConfigureActivity}
 */
public class WeatherWidget extends AppWidgetProvider {


    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        SharedPreferences sharedPreferences = context.getSharedPreferences("data" , Context.MODE_PRIVATE);
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



        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_widget);
        views.setTextViewText(R.id.widget_cairo, cairo);
        views.setTextViewText(R.id.widget_cairo_temp , String.valueOf(cairoTemp + "c"));
        views.setTextViewText(R.id.widget_alexandria , alex);
        views.setTextViewText(R.id.widget_alexandria_temp , String.valueOf(alexTemp + "c"));
        views.setTextViewText(R.id.widget_aswan , aswan);
        views.setTextViewText(R.id.widget_aswan_temp , String.valueOf(aswanTemp + "c"));
        views.setTextViewText(R.id.widget_luxor , luxor);
        views.setTextViewText(R.id.widget_luxor_temp , String.valueOf(luxorTemp + "c"));
        views.setTextViewText(R.id.widget_matruh , matruh);
        views.setTextViewText(R.id.widget_matruh_temp , String.valueOf(matruhTemp + "c"));

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }




    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

        }
    }



    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            WeatherWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

