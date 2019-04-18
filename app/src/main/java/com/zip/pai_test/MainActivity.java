package com.zip.pai_test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

//bottomNavigation+fragment參考 https://www.youtube.com/watch?v=jpaHMcQDaDg   or  https://www.youtube.com/watch?v=tPV8xA7m-iw

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
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



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment =null;
        switch(menuItem.getItemId()){
            case R.id.navigation_home:
                fragment=new HomeFragment();
                break;
            case R.id.navigation_record:
                fragment=new RecordFragment();
                break;
            case R.id.navigation_member:
                fragment=new MemberFragment();
                break;
            case R.id.navigation_map:
                fragment=new MapFragment();
//                FragmentManager manager = getSupportFragmentManager();
//                manager.beginTransaction().replace()

                break;
            case R.id.navigation_list:
                fragment=new ListFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }
}
