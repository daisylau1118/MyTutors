package com.technovation.mytutors;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static FragmentManager fragmentManager;

    /*
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.homeButtonBottomBar:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new HomepageFragment(), null).addToBackStack(null).commit();
                    return true;
                case R.id.calendarButtonBottomBar:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new ScheduleFragment(), null).addToBackStack(null).commit();
                    return true;
                case R.id.profileButtonBottomBar:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new ProfileFragment(), null).addToBackStack(null).commit();
                    return true;
                case R.id.chatButtonBottomBar:
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new MessagesFragment(), null).addToBackStack(null).commit();
                    return true;
            }
            return false;
        }
    };
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.FragmentContainer)!=null)
        {
            if (savedInstanceState != null)
            {
                return;
            }
            FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

            HomepageFragment homepageFragment = new HomepageFragment();

            fragmentTransaction.add(R.id.FragmentContainer, homepageFragment, null);
            fragmentTransaction.commit();
        }

        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ///*

        // changing fragment to schedule if calender icon on bottom bar is clicked
        ImageButton scheduleButton = (ImageButton)findViewById(R.id.calendarButtonBottomBar);
        scheduleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new ScheduleFragment(), null).addToBackStack(null).commit();
                }
            });


        // changing fragment to profile if profile icon on bottom bar is clicked
        ImageButton profileButton = (ImageButton)findViewById(R.id.profileButtonBottomBar);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new ProfileFragment(), null).addToBackStack(null).commit();
            }
        });

        // changing fragment to home if home icon on bottom bar is clicked
        ImageButton homeButton = (ImageButton)findViewById(R.id.homeButtonBottomBar);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new HomepageFragment(), null).addToBackStack(null).commit();
            }
        });

        // changing fragment to chat if chat icon on bottom bar is clicked
        ImageButton chatButton = (ImageButton)findViewById(R.id.chatButtonBottomBar);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new MessagesFragment(), null).addToBackStack(null).commit();
            }
        });

        //*/







    }



}
