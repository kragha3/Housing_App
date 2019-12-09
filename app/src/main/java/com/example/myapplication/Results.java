package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    private Button searchAgain;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        searchAgain = (Button) findViewById(R.id.searchAgain);
        searchAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMain();
            }
        });


    }
    private void graphData() {
        /**
         * retreives intent data to populate bar chart.
         */
        getIntent();
        String value = getIntent().getStringExtra("price");
        String location = getIntent().getStringExtra("location");
        String room = getIntent().getStringExtra("room");
        String bathrooms = getIntent().getStringExtra("bathroom");
        /**
         * Location of the following code is uncertain :/.
         */
        barChart = findViewById(R.id.mp_BarChart);
        BarDataSet barDataSet1 = new BarDataSet(dataValues(), "DataSet1");
        BarData barData = new BarData();
        barData.addDataSet(barDataSet1);
        barChart.setData(barData);
        barChart.invalidate();

    }
    private ArrayList<BarEntry> dataValues() {
        /**
         * adds location points for each apartment (?).
         */
        ArrayList<BarEntry> dataVals = new ArrayList<BarEntry>();
        /**
         * Data to populate the graph with.
         */
        dataVals.add(new BarEntry(0,1));

        return dataVals;
    }

    private void launchMain() {
        /**
         * launchMain() takes the app back to the main screen.
         */
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    /**
     * Make a point system for matching.
     */
    Apartment apartment1 = new Apartment("Bailey Student Apartments", 700, 2, 2,1, 1, "Near Bardeen Quad");
    Apartment apartment2 = new Apartment("40 E John Apartments",400, 1, 3,3, 2, "Near Ike");
    Apartment apartment3 = new Apartment("507 S 4th Apartments",445, 1, 2, 4, 2, "Near Bardeen Quad");
    Apartment apartment4 = new Apartment("55 E Green St",900, 3,4,2, 2, "Near Green St.");
    Apartment apartment5 = new Apartment("102 E Gregory Dr.",512, 1, 3,2,1, "Near Ike");
    Apartment apartment6 = new Apartment("102 E Gregory Dr. (2)",478, 1, 3, 3,2, "Near Ike");
    Apartment apartment7 = new Apartment("615 S Wright St.",1185, 3, 2, 2, 1, "Near Bardeen Quad");
    Apartment apartment8 = new Apartment("need name",1060, 3, 1,1, 1, "Near Main Quad");
    Apartment apartment9 = new Apartment("408 E Healey",722, 2, 1,4, 2, "Near Main Quad");


}
