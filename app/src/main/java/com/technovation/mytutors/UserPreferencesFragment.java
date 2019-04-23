package com.technovation.mytutors;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserPreferencesFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
    private DocumentReference prefRef = db.collection("users").document(currentUser);

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

        prefRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            //subject
                            if (documentSnapshot.getBoolean("subject.math")!=null){
                                Boolean math = documentSnapshot.getBoolean("subject.math");
                                if (math)
                                    subject0.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("subject.ela")!=null){
                                Boolean ela = documentSnapshot.getBoolean("subject.ela");
                                if (ela)
                                    subject1.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("subject.social")!=null){
                                Boolean social = documentSnapshot.getBoolean("subject.social");
                                if (social)
                                    subject2.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("subject.languages")!=null){
                                Boolean languages = documentSnapshot.getBoolean("subject.languages");
                                if (languages)
                                    subject3.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("subject.science")!=null){
                                Boolean science = documentSnapshot.getBoolean("subject.science");
                                if (science)
                                    subject4.setChecked(true);
                            }

                            //level
                            if (documentSnapshot.getBoolean("level.elementary")!=null){
                                Boolean elementary = documentSnapshot.getBoolean("level.elementary");
                                if (elementary)
                                    level0.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("level.junior")!=null){
                                Boolean junior = documentSnapshot.getBoolean("level.junior");
                                if (junior)
                                    level1.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("level.senior")!=null){
                                Boolean senior = documentSnapshot.getBoolean("level.senior");
                                if (senior)
                                    level2.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("level.post_secondary")!=null){
                                Boolean postSec = documentSnapshot.getBoolean("level.post_secondary");
                                if (postSec)
                                    level3.setChecked(true);
                            }

                            //availability
                            if (documentSnapshot.getBoolean("availability.monday")!=null){
                                Boolean mon = documentSnapshot.getBoolean("availability.monday");
                                if (mon)
                                    availability0.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("availability.tuesday")!=null){
                                Boolean tues = documentSnapshot.getBoolean("availability.tuesday");
                                if (tues)
                                    availability1.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("availability.wednesday")!=null){
                                Boolean wed = documentSnapshot.getBoolean("availability.wednesday");
                                if (wed)
                                    availability2.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("availability.thursday")!=null){
                                Boolean thurs = documentSnapshot.getBoolean("availability.thursday");
                                if (thurs)
                                    availability3.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("availability.friday")!=null){
                                Boolean fri = documentSnapshot.getBoolean("availability.friday");
                                if (fri)
                                    availability4.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("availability.saturday")!=null){
                                Boolean sat = documentSnapshot.getBoolean("availability.saturday");
                                if (sat)
                                    availability5.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("availability.sunday")!=null){
                                Boolean sun = documentSnapshot.getBoolean("availability.sunday");
                                if (sun)
                                    availability6.setChecked(true);
                            }

                            //other
                            if (documentSnapshot.getBoolean("other.meet_at_home")!=null){
                                Boolean meethome = documentSnapshot.getBoolean("other.meet_at_home");
                                if (meethome)
                                    other0.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("other.meet_in_public")!=null){
                                Boolean meetpublic = documentSnapshot.getBoolean("other.meet_in_public");
                                if (meetpublic)
                                    other1.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("other.french_immersion")!=null){
                                Boolean frenchIm = documentSnapshot.getBoolean("other.french_immersion");
                                if (frenchIm)
                                    other2.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("other.slow_learner")!=null){
                                Boolean slowLearner = documentSnapshot.getBoolean("other.slow_learner");
                                if (slowLearner)
                                    other3.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("other.adhd_add")!=null){
                                Boolean adhd = documentSnapshot.getBoolean("other.adhd_add");
                                if (adhd)
                                    other4.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("other.hearing_impaired")!=null){
                                Boolean hearing = documentSnapshot.getBoolean("other.hearing_impaired");
                                if (hearing)
                                    other5.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("other.english_second_language")!=null){
                                Boolean esl = documentSnapshot.getBoolean("other.english_second_language");
                                if (esl)
                                    other6.setChecked(true);
                            }
                            if (documentSnapshot.getBoolean("other.learning disability")!=null){
                                Boolean learnDisb = documentSnapshot.getBoolean("other.learning disability");
                                if (learnDisb)
                                    other7.setChecked(true);
                            }







                        }
                        else{
                            Toast.makeText(getContext(),"document does not exist",Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(),"failure to read document",Toast.LENGTH_SHORT).show();
                    }
                });

        return view;

    }


    public void onCheckboxClicked(View view) {
        //found in main activity
    }
}
