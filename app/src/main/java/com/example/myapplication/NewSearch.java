package com.example.myapplication;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
//import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewSearch extends AppCompatActivity {

    private Button search;

    private int priceSelected;

    private Spinner price;

    private int locationSelected;

    private Spinner location;

    private int roomSelected;

    private Spinner rooms;

    private int bathSelected;

    private Spinner bathrooms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_search);

        price = findViewById(R.id.priceOptions);
        ArrayList<String> priceList = new ArrayList<>();
        priceList.add("$400-600");
        priceList.add("$600-800");
        priceList.add("$800+");
        ArrayAdapter<String> setPrice = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, priceList);
        setPrice.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        price.setAdapter(setPrice);


        location = findViewById(R.id.locationOptions);
        ArrayList<String> locationList = new ArrayList<>();
        locationList.add("Near Main Quad");
        locationList.add("Near Bardeen Quad");
        locationList.add("Near Ikenberry");
        locationList.add("Near Green St.");
        ArrayAdapter<String> setLocation = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, locationList);
        setLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        location.setAdapter(setLocation);

        rooms = findViewById(R.id.roomOptions);
        ArrayList<String> roomList = new ArrayList<>();
        roomList.add("1");
        roomList.add("2");
        roomList.add("3");
        roomList.add("4");
        ArrayAdapter<String> setRooms = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, roomList);
        setRooms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rooms.setAdapter(setRooms);

        bathrooms = findViewById(R.id.bathroomOptions);
        ArrayList<String> bathroomList = new ArrayList<>();
        bathroomList.add("1");
        bathroomList.add("2");
        bathroomList.add("3");
        bathroomList.add("4");
        ArrayAdapter<String> setBathrooms = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, bathroomList);
        setBathrooms.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bathrooms.setAdapter(setBathrooms);

        search = (Button) findViewById(R.id.searchButton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchResults();
            }
        });

    }


    private void launchResults() {
        Intent intent = new Intent(this, Results.class);
        priceSelected = price.getSelectedItemPosition();
        locationSelected = location.getSelectedItemPosition();
        roomSelected = rooms.getSelectedItemPosition();
        bathSelected = bathrooms.getSelectedItemPosition();
        intent.putExtra("price", priceSelected + 1);
        intent.putExtra("location", locationSelected + 1);
        intent.putExtra("rooms", roomSelected + 1);
        intent.putExtra("bathrooms", bathSelected + 1);
        startActivity(intent);
    }

}
