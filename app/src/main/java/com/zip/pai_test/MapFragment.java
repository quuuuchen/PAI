package com.zip.pai_test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


// map activity in fragment 參考: https://www.youtube.com/watch?v=Cy4EraxUan4

public class MapFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap mMap;
    GoogleMap map;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,null);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onMapReady(GoogleMap googlemap){

        mMap = googlemap;

        // Add a marker in HK and move the camera
        LatLng cpark = new LatLng(22.260140, 114.131494);
        mMap.addMarker(new MarkerOptions().position(cpark).title("Cyberport Three Car Park"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cpark));


    }
}
