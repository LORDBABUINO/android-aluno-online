package com.example.lordbabuino.aluno_online;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment fragmentMap = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentMap);
        fragmentMap.getMapAsync( this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng iesb = new LatLng(-15.8383607, -47.9175002);
        googleMap.addMarker(new MarkerOptions().position(iesb).title("IESB"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(iesb, 18));
    }
}
