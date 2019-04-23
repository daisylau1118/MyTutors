package com.technovation.mytutors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserPreferencesFragment extends Fragment {

    private CheckBox subject0; // math
    private CheckBox subject1; // ela
    private CheckBox subject2; // lang
    private CheckBox subject3; // social
    private CheckBox subject4; // science

    private CheckBox level0; // elementary
    private CheckBox level1; // junior
    private CheckBox level2; // high school
    private CheckBox level3; // post secondary

    private CheckBox availability0; // mon
    private CheckBox availability1; // tues
    private CheckBox availability2; // wed
    private CheckBox availability3; // thurs
    private CheckBox availability4; // fri
    private CheckBox availability5; // sat
    private CheckBox availability6; // sun

    private CheckBox other0; // meet home
    private CheckBox other1; //meet public
    private CheckBox other2; // french immersion
    private CheckBox other3; // slow learner
    private CheckBox other4; // adhd/add
    private CheckBox other5; // hearing
    private CheckBox other6; // esl
    private CheckBox other7; // learning disability
    

    public UserPreferencesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_preferences, container, false);

        subject0 = view.findViewById(R.id.subject_cb_0);
        subject1 = view.findViewById(R.id.subject_cb_1);
        subject2 = view.findViewById(R.id.subject_cb_2);
        subject3 = view.findViewById(R.id.subject_cb_3);
        subject4 = view.findViewById(R.id.subject_cb_4);

        level0 = view.findViewById(R.id.level_cb_0);
        level1 = view.findViewById(R.id.level_cb_1);
        level2 = view.findViewById(R.id.level_cb_2);
        level3 = view.findViewById(R.id.level_cb_3);

        availability0 = view.findViewById(R.id.availability_cb_0);
        availability1 = view.findViewById(R.id.availability_cb_1);
        availability2 = view.findViewById(R.id.availability_cb_2);
        availability3 = view.findViewById(R.id.availability_cb_3);
        availability4 = view.findViewById(R.id.availability_cb_4);
        availability5 = view.findViewById(R.id.availability_cb_5);
        availability6 = view.findViewById(R.id.availability_cb_6);

        other0 = view.findViewById(R.id.other_cb_0);
        other1 = view.findViewById(R.id.other_cb_1);
        other2 = view.findViewById(R.id.other_cb_2);
        other3 = view.findViewById(R.id.other_cb_3);
        other4 = view.findViewById(R.id.other_cb_4);
        other5 = view.findViewById(R.id.other_cb_5);
        other6 = view.findViewById(R.id.other_cb_6);
        other7 = view.findViewById(R.id.other_cb_7);

        return view;

    }

    public void onCheckboxClicked(View view) {
        //found in main activity
    }
}
