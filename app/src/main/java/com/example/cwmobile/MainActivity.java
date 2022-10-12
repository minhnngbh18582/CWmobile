package com.example.cwmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewTrip;
    Button btnNewTrip;
    TripListViewAdapter tripListViewAdapter;
    ArrayList<Trip> listTrip;
    DatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewTrip = findViewById(R.id.buttonNewTrip);
        btnNewTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTrip.class);
                startActivity(intent);
            }
        });

//        tripListViewAdapter = new TripListViewAdapter(listTrip);

//        listViewTrip = findViewById(R.id.listviewTrip);
//        listViewTrip.setAdapter(tripListViewAdapter);
    }
}