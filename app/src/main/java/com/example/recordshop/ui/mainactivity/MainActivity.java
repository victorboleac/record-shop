package com.example.recordshop.ui.mainactivity;


import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recordshop.R;
import com.example.recordshop.navigation.fragments.AddFragment;
import com.example.recordshop.navigation.fragments.FavouritesFragment;
import com.example.recordshop.navigation.fragments.HomeFragment;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    NavigationBarView bottomNavigationView;
    AddFragment addFragment = new AddFragment();
    HomeFragment homeFragment = new HomeFragment();
    FavouritesFragment favouritesFragment = new FavouritesFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

   }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.home){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment,homeFragment)
                    .commit();
            return true;
        }
        return false;
    }




}