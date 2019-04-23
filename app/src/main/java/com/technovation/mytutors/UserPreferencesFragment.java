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
    /*
    private CheckBox subject0; // math
    private CheckBox subject1; // ela
    private CheckBox subject2; // lang
    private CheckBox subject3; // social
    private CheckBox subject4; // science
    //subject
    private boolean math = false;
    private boolean ela = false;
    private boolean lang = false;
    private boolean social = false;
    private boolean science = false;


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
    */
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private FirebaseFirestore db;

    public UserPreferencesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_preferences, container, false);
        /*
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
        */
        return view;

    }

    public void onCheckboxClicked(View view) {
        //found in main activity
        /*
        boolean checked = ((CheckBox) view).isChecked();
        CollectionReference users = db.collection("users"); //delete/move??????

        // Check which checkbox was clicked
        switch(view.getId()) {
            //subject
            case R.id.subject_cb_0: //math
                if (checked) {
                    Toast.makeText(getContext(), "math", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.subject_cb_1: //ela
                if (checked) {
                    Map<String, Boolean> data = new HashMap<>();
                    data.put("ela", true);
                    users.document(user.getUid().toString()).set(data);
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
        */
    }
}
