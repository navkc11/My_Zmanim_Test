package com.example.myzmanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.Object;
import java.util.ArrayList;
import java.util.TimeZone;


import com.kosherjava.zmanim.AstronomicalCalendar;
import com.kosherjava.zmanim.ComplexZmanimCalendar;
import com.kosherjava.zmanim.util.GeoLocation;
import com.kosherjava.zmanim.ZmanimCalendar;
import com.kosherjava.zmanim.AstronomicalCalendar;

public class MainActivity extends AppCompatActivity {

    ListView zmanimList;
    String locationName = "Jerusalem, Israel";
    double latitude = 31.7767; //Western Wall, Israel
    double longitude = 35.2345; //Western Wall, Israel
    double elevation = 800; //optional elevation
    TimeZone timeZone = TimeZone.getTimeZone("Asia/Jerusalem");
    GeoLocation location = new GeoLocation(locationName, latitude, longitude, elevation, timeZone);
    ComplexZmanimCalendar czc = new ComplexZmanimCalendar(location);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zmanimList = (ListView) findViewById(R.id.zmanim_list);

        ArrayList<String> categories = new ArrayList<>();
        boolean sunrise = categories.add("עלות השחר:"+ czc.getAlosHashachar());
        boolean sunset = categories.add("שקיעה:"+ czc.getSunset());

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, categories);

        zmanimList.setAdapter(arrayAdapter);
    }
}