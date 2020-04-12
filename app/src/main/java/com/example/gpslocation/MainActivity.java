package com.example.gpslocation;

import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient client;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = LocationServices.getFusedLocationProviderClient(this);
        client.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location != null) {
                            textView = findViewById(R.id.Text);
                            double x = location.getLongitude();
                            double y = location.getLatitude();
                            String xValue = String.valueOf(x);
                            String yValue = String.valueOf(y);
                            textView.setText(xValue + "" + yValue);
                        }

                    }
                });


    }
}
