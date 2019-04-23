package com.technovation.mytutors;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public static FragmentManager fragmentManager;
    private FirebaseFirestore db;
    private DatabaseReference mDatabase;
    private String currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();


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

            //HomepageFragment homepageFragment = new HomepageFragment();
           HomepageFragment homepageFragment = new HomepageFragment();

            //fragmentTransaction.add(R.id.FragmentContainer, homepageFragment, null);
            fragmentTransaction.add(R.id.FragmentContainer, homepageFragment, null);
            fragmentTransaction.commit();
        }

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

        mDatabase = FirebaseDatabase.getInstance().getReference("users");
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        //DocumentReference user = db.document("/users/" +currentUser );

        // Check which checkbox was clicked
        switch(view.getId()) {
            //subject
            case R.id.subject_cb_0: //math
                if (checked) {
                    Toast.makeText(this, "math", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.subject_cb_1: //ela
                if (checked) {
                    //CollectionReference users = db.collection("/users");
                    //Map<String, Boolean> data = new HashMap<>();
                    //data.put("ela", true);
                    //user.set(data); // make sure uid matches document id
                }

                break;
            case R.id.subject_cb_2://language
                if (checked) {

                }
                break;
            case R.id.subject_cb_3: //social
                if (checked) {

                }
                break;
            case R.id.subject_cb_4:// science
                if (checked) {

                }
                break;

            //level
            case R.id.level_cb_0: //elementary
                if (checked) {

                }
                break;
            case R.id.level_cb_1: // junior high
                if (checked) {

                }
                break;
            case R.id.level_cb_2: // high school
                if (checked) {

                }
                break;
            case R.id.level_cb_3: // post secondary
                if (checked) {

                }
                break;

            //availability
            case R.id.availability_cb_0: // mon
                if (checked) {

                }
                break;
            case R.id.availability_cb_1: // tues
                if (checked) {

                }
                break;
            case R.id.availability_cb_2: //wed
                if (checked) {

                }
                break;
            case R.id.availability_cb_3: //thurs
                if (checked) {

                }
                break;
            case R.id.availability_cb_4: // fri
                if (checked) {

                }
                break;
            case R.id.availability_cb_5: // sat
                if (checked) {

                }
                break;
            case R.id.availability_cb_6: // sun
                if (checked) {

                }
                break;

            //other
            case R.id.other_cb_0: // meet home
                if (checked) {

                }
                break;
            case R.id.other_cb_1: // meet public
                if (checked) {

                }
                break;
            case R.id.other_cb_2: // french immersion
                if (checked) {

                }
                break;
            case R.id.other_cb_3: // slow learner
                if (checked) {

                }
                break;
                case R.id.other_cb_4: // ADHD/ADD
                if (checked) {

                }
                break;
            case R.id.other_cb_5: // hearing impaired
                if (checked) {

                }
                break;
            case R.id.other_cb_6: // esl
                if (checked) {

                }
                break;
            case R.id.other_cb_7: // learning disability
                if (checked) {

                }
                break;
        }
    }



}
