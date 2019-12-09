package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    private Button searchAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        searchAgain = (Button) findViewById(R.id.searchAgain);
        searchAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMain();
            }
        });

    }

    private void launchMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
