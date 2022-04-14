package com.benter.googlemapdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.switchmaterial.SwitchMaterial;


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    public SupportMapFragment mapFragment;
    public GoogleMap map;
    public   Switch locationSwitch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_id);
        mapFragment.getMapAsync(this);
        locationSwitch = findViewById(R.id.switch_id);
        locationSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Requesting Permission
                requestPermission();


            }
        });



    }
    /*End of onCreate method*/

    //forgetting user permission
    private void requestPermission() {

        if (locationSwitch.isChecked()){
            if (ActivityCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                //We will show the location
            }
            //when the permission is denied
            else{
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION
                },6);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==6){
            if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                //we'll resume form there
            }

        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}
