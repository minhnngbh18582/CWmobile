package com.example.cwmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTrip extends AppCompatActivity {

    EditText edtTripName, edtTripDestination, edtTripDate, edtTripRisk, edtTripDescription, edtTripParticipants;
    Button btnCreate;
    DatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trip);

        edtTripName = findViewById(R.id.editTextTripName);
        edtTripDestination = findViewById(R.id.editTextTripDestination);
        edtTripDate = findViewById(R.id.editTextTripDate);
        edtTripRisk = findViewById(R.id.editTextTripRisk);
        edtTripDescription = findViewById(R.id.editTextTripDescription);
        edtTripParticipants = findViewById(R.id.editTextTripParticipants);

        btnCreate = findViewById(R.id.buttonCreate);

        database = new DatabaseHelper(getApplicationContext());

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trip objTrip = new Trip(edtTripName.getText().toString(),edtTripDestination.getText().toString(),edtTripDate.getText().toString(),edtTripRisk.getText().toString(),edtTripDescription.getText().toString(),Integer.parseInt(edtTripParticipants.getText().toString()));

                if(database.InsertTrip(objTrip))
                    Toast.makeText(getApplicationContext(),"Trip created successfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Failed to create trip",Toast.LENGTH_LONG).show();
            }
        });

    }
}