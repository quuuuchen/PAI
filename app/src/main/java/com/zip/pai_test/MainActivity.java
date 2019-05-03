package com.zip.pai_test;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.Manifest;

//bottomNavigation+fragment參考 https://www.youtube.com/watch?v=jpaHMcQDaDg   or  https://www.youtube.com/watch?v=tPV8xA7m-iw

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());


        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("我真的沒有要做壞事, 給我權限吧?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
            } else {

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    finish();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();

            return true;
        }
        return false;
    }


    int achcounter =0;


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment =null;
        switch(menuItem.getItemId()){
            case R.id.navigation_home:
                fragment=new HomeFragment();
                break;
            case R.id.navigation_record:
                fragment=new RecordFragment();
                if(achcounter==0) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setPositiveButton("好", null);
                    final View item = LayoutInflater.from(this).inflate(R.layout.congra_ach, null);
                    alert.setView(item);
                    alert.show();
                    achcounter++;
                }
                break;
            case R.id.navigation_member:
                fragment=new MemberFragment();
                break;
            case R.id.navigation_map:
                fragment=new MapFragment();
//                FragmentManager manager = getSupportFragmentManager();
//                manager.beginTransaction().replace();

                break;
            case R.id.navigation_list:
                fragment=new ListFragment();

                break;
        }
        return loadFragment(fragment);
    }
    public void car_MAP(View view) {
        final AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
        final View item = LayoutInflater.from(this).inflate(R.layout.alertdialog_parkmap, null);
        alert2.setView(item);
        alert2.setPositiveButton("好",null);
        alert2.show();
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }






}
