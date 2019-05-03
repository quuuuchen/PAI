package com.zip.pai_test;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.Manifest;
import android.widget.Toast;


// map activity in fragment 參考: https://www.youtube.com/watch?v=Cy4EraxUan4

public class MapFragment extends Fragment
        implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback{

    GoogleMap mMap;

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
        LatLng cpark3 = new LatLng(22.260140, 114.131494);
        mMap.addMarker(new MarkerOptions()
                .position(cpark3)
                .title("數碼港三座停車場")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_y))
        );
        LatLng cpark2 = new LatLng(22.262212, 114.130770);
        mMap.addMarker(new MarkerOptions()
                .position(cpark2)
                .title("數碼港二座停車場")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_y))
        );
        LatLng cpark1 = new LatLng(22.257859, 114.131976);
        mMap.addMarker(new MarkerOptions()
                .position(cpark1)
                .title("貝沙灣一及二期停車場")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_y))
        );
        LatLng gas1 = new LatLng(22.275005, 114.129991);
        mMap.addMarker(new MarkerOptions()
                .position(gas1)
                .title("Caltex 加油站")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_b))
        );


        //取得使用者定位

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
            AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
            alert.setTitle("請允許定位");
            alert.setPositiveButton("確認",null);
            alert.show();
        }

        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(cpark3));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));

    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(getContext(), "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(getContext(), "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

}
