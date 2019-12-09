package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class Results extends AppCompatActivity {

    private Button details;

    BarChart barChart;

    private int priceSelected;

    private int locationSelected;

    private int roomSelected;

    private int bathSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        getIntent();
        priceSelected = getIntent().getIntExtra("price", 0);
        locationSelected = getIntent().getIntExtra("location", 0);
        roomSelected = getIntent().getIntExtra("rooms", 0);
        bathSelected = getIntent().getIntExtra("bathrooms", 0);

        barChart = findViewById(R.id.mp_BarChart);
        BarDataSet barDataSet1 = new BarDataSet(dataValues(), "Apartments");
        BarData barData = new BarData();
        barData.addDataSet(barDataSet1);
        barChart.setData(barData);
        barChart.invalidate();

        details = (Button) findViewById(R.id.details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchDetails();
            }
        });

    }

    private ArrayList<BarEntry> dataValues() {
        /**
         * adds location points for each apartment (?).
         */
        ArrayList<BarEntry> dataVals = new ArrayList<BarEntry>();
        /**
         * Data to populate the graph with.
         */
        dataVals.add(new BarEntry(1,points(apartment1)));
        dataVals.add(new BarEntry(2,points(apartment2)));
        dataVals.add(new BarEntry(3,points(apartment3)));
        dataVals.add(new BarEntry(4,points(apartment4)));
        dataVals.add(new BarEntry(5,points(apartment5)));
        dataVals.add(new BarEntry(6,points(apartment6)));
        dataVals.add(new BarEntry(7,points(apartment7)));
        dataVals.add(new BarEntry(8,points(apartment8)));
        dataVals.add(new BarEntry(9,points(apartment9)));
        XAxis x = barChart.getXAxis();
        String[] values = new String[] {"Apt 1", "Apt 2", "Apt 3", "Apt 4", "Apt 5", "Apt 6",
                "Apt 7", "Apt 8", "Apt 9"};
        x.setValueFormatter(new MyXAxisValueFormatter(values));

        return dataVals;
    }

    private void launchDetails() {
        /**
         * launchMain() takes the app back to the main screen.
         */
        Intent intent = new Intent(this, Details.class);
        startActivity(intent);

    }
    public int points(Apartment input) {
        if (input.getPriceIndex() == priceSelected) {
            input.addPoint();
        }
        if (input.getLocationIndex() == locationSelected) {
            input.addPoint();
        }
        if (input.getBathrooms() == bathSelected) {
            input.addPoint();
        }
        if (input.getBedrooms() == roomSelected) {
            input.addPoint();
        }
        return input.getPoints();
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
    Apartment apartment8 = new Apartment("707 S 6th St.",1060, 3, 1,1, 1, "Near Main Quad");
    Apartment apartment9 = new Apartment("408 E Healey",722, 2, 1,4, 2, "Near Main Quad");
}
