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
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public static FragmentManager fragmentManager;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
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

        CollectionReference users = db.collection("users");

        // Check which checkbox was clicked
        switch(view.getId()) {

            case R.id.tutor_cb:
                    if (checked) {
                        Map<String, Object> data = new HashMap<>();
                        data.put("isTutor", true);
                        db.collection("tutors").document(currentUser).set(data); // makes
                    } else
                        db.collection("tutors").document(currentUser).update("isTutor", false);

                break;
            //subject
            case R.id.subject_cb_0: //math
                if (checked)
                    users.document(currentUser).update("subject.math", true);
                else
                    users.document(currentUser).update("subject.math", false);
                break;
            case R.id.subject_cb_1: //ela
                if (checked)
                    users.document(currentUser).update("subject.ela", true);
                else
                    users.document(currentUser).update("subject.ela", false);
                break;
            case R.id.subject_cb_2://language
                if (checked)
                    users.document(currentUser).update("subject.languages", true);
                else
                    users.document(currentUser).update("subject.languages", false);
                break;
            case R.id.subject_cb_3: //social
                if (checked)
                    users.document(currentUser).update("subject.social", true);
                else
                    users.document(currentUser).update("subject.social", false);
                break;
            case R.id.subject_cb_4:// science
                if (checked)
                    users.document(currentUser).update("subject.science", true);
                else
                    users.document(currentUser).update("subject.science", false);
                break;

            //level
            case R.id.level_cb_0: //elementary
                if (checked)
                    users.document(currentUser).update("level.elementary", true);
                else
                    users.document(currentUser).update("level.elementary", false);
                break;
            case R.id.level_cb_1: // junior high
                if (checked)
                    users.document(currentUser).update("level.junior", true);
                else
                    users.document(currentUser).update("level.junior", false);
                break;
            case R.id.level_cb_2: // high school
                if (checked)
                    users.document(currentUser).update("level.senior", true);
                else
                    users.document(currentUser).update("level.senior", false);
                break;
            case R.id.level_cb_3: // post secondary
                if (checked)
                    users.document(currentUser).update("level.post_secondary", true);
                else
                    users.document(currentUser).update("level.post_secondary", false);
                break;

            //availability
            case R.id.availability_cb_0: // mon
                if (checked)
                    users.document(currentUser).update("availability.monday", true);
                else
                    users.document(currentUser).update("availability.monday", false);
                break;
            case R.id.availability_cb_1: // tues
                if (checked)
                    users.document(currentUser).update("availability.tuesday", true);
                else
                    users.document(currentUser).update("availability.tuesday", false);
                break;
            case R.id.availability_cb_2: //wed
                if (checked)
                    users.document(currentUser).update("availability.wednesday", true);
                else
                    users.document(currentUser).update("availability.wednesday", false);
                break;
            case R.id.availability_cb_3: //thurs
                if (checked)
                    users.document(currentUser).update("availability.thursday", true);
                else
                    users.document(currentUser).update("availability.thursday", false);
                break;
            case R.id.availability_cb_4: // fri
                if (checked)
                    users.document(currentUser).update("availability.friday", true);
                else
                    users.document(currentUser).update("availability.friday", false);
                break;
            case R.id.availability_cb_5: // sat
                if (checked)
                    users.document(currentUser).update("availability.saturday", true);
                else
                    users.document(currentUser).update("availability.saturday", false);
                break;
            case R.id.availability_cb_6: // sun
                if (checked)
                    users.document(currentUser).update("availability.sunday", true);
                else
                    users.document(currentUser).update("availability.sunday", false);
                break;

            //other
            case R.id.other_cb_0: // meet home
                if (checked)
                    users.document(currentUser).update("other.meet_at_home", true);
                else
                    users.document(currentUser).update("other.meet_at_home", false);
                break;
            case R.id.other_cb_1: // meet public
                if (checked)
                    users.document(currentUser).update("other.meet_in_public", true);
                else
                    users.document(currentUser).update("other.meet_in_public", false);
                break;
            case R.id.other_cb_2: // french immersion
                if (checked)
                    users.document(currentUser).update("other.french_immersion", true);
                else
                    users.document(currentUser).update("other.french_immersion", false);
                break;
            case R.id.other_cb_3: // slow learner
                if (checked)
                    users.document(currentUser).update("other.slow_learner", true);
                else
                    users.document(currentUser).update("other.slow_learner", false);
                break;
            case R.id.other_cb_4: // ADHD/ADD
                if (checked)
                    users.document(currentUser).update("other.adhd_add", true);
                else
                    users.document(currentUser).update("other.adhd_add", false);
            break;
            case R.id.other_cb_5: // hearing impaired
                if (checked)
                    users.document(currentUser).update("other.hearing_impaired", true);
                else
                    users.document(currentUser).update("other.hearing_impaired", false);
                break;
            case R.id.other_cb_6: // esl
                if (checked)
                    users.document(currentUser).update("other.english_second_language", true);
                else
                    users.document(currentUser).update("other.english_second_language", false);
                break;
            case R.id.other_cb_7: // learning disability
                if (checked)
                    users.document(currentUser).update("other.learning disability", true);
                else
                    users.document(currentUser).update("other.learning disability", false);
                break;
        }
    }



}
