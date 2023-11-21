package com.example.corporatedinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    InformationFragment informationFragment;
    FavouriteFragment favouriteFragment;
    OrderFragment orderFragment;
    ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            getSupportFragmentManager().popBackStack();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        informationFragment = new InformationFragment();
        favouriteFragment = new FavouriteFragment();
        orderFragment = new OrderFragment();
        profileFragment = new ProfileFragment();

        transaction.add(R.id.frame_layout, informationFragment);
        transaction.add(R.id.frame_layout, favouriteFragment);
        transaction.add(R.id.frame_layout, orderFragment);
        transaction.add(R.id.frame_layout, profileFragment);
        transaction.hide(favouriteFragment);
        transaction.hide(orderFragment);
        transaction.hide(profileFragment);
        transaction.commit();

        ImageButton informationButton = findViewById(R.id.information_button);
        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(informationFragment);
            }
        });

        ImageButton favouriteButton = findViewById(R.id.favourite_button);
        favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(favouriteFragment);
            }
        });

        ImageButton orderButton = findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(orderFragment);
            }
        });

        ImageButton profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(profileFragment);
            }
        });

        ImageButton adminPanelButton = findViewById(R.id.admin_panel_button);
        adminPanelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdminPanelActivity.class));
            }
        });
    }

    void changeFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(informationFragment);
        transaction.hide(favouriteFragment);
        transaction.hide(orderFragment);
        transaction.hide(profileFragment);
        transaction.show(fragment);
        transaction.commit();
    }
}