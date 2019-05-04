package com.technovation.mytutors;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {

    private FirebaseAuth mAuth;
    private Button edit;
    private Button logout;

    private TextView userName;
    private TextView status;
    private RatingBar rating;
    private TextView preferences;
    private TextView availability;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
    private DocumentReference nameRef = db.collection("users").document(currentUser);
    private StringBuffer sbdays = new StringBuffer();
    private StringBuffer sbpref = new StringBuffer();


    public MyProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        //changing fragment to edit pref if btn clicked
        edit = view.findViewById(R.id.edit_pref_btn);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new UserPreferencesFragment(), null).addToBackStack(null).commit();
            }
        });

        // logout button -- need to fix changing to login activity
        logout = view.findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), LoginActivity.class));

            }
        });

        userName = view.findViewById(R.id.userName);
        status = view.findViewById(R.id.userstatus);
        rating = view.findViewById(R.id.userRating);

        preferences = view.findViewById(R.id.preferences);
        availability = view.findViewById(R.id.availability);

        nameRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            String first = documentSnapshot.getString("first_name");
                            String last = documentSnapshot.getString("last_name");

                            userName.setText(first + " "+ last);

                            boolean isTutor = documentSnapshot.getBoolean("isTutor");

                            if (isTutor){ //user is tutor
                                status.setText("Tutor");
                                rating.setVisibility(View.VISIBLE);
                            }
                            else // user is student
                                status.setText("Student");


                            //SETTING BIO

                            //PREF
                            String pref = "";
                            //subject
                            if (documentSnapshot.getBoolean("subject.math")!=null){
                                Boolean math = documentSnapshot.getBoolean("subject.math");
                                if (math)
                                    pref = sbpref.append("Math,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("subject.ela")!=null){
                                Boolean ela = documentSnapshot.getBoolean("subject.ela");
                                if (ela)
                                    pref = sbpref.append("ELA,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("subject.social")!=null){
                                Boolean social = documentSnapshot.getBoolean("subject.social");
                                if (social)
                                    pref = sbpref.append("Social Studies,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("subject.languages")!=null){
                                Boolean languages = documentSnapshot.getBoolean("subject.languages");
                                if (languages)
                                    pref = sbpref.append("Languages,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("subject.science")!=null){
                                Boolean science = documentSnapshot.getBoolean("subject.science");
                                if (science)
                                    pref = sbpref.append("Science,  ").toString();
                            }
                            //level
                            if (documentSnapshot.getBoolean("level.elementary")!=null){
                                Boolean elementary = documentSnapshot.getBoolean("level.elementary");
                                if (elementary)
                                    pref = sbpref.append("Elementry,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("level.junior")!=null){
                                Boolean junior = documentSnapshot.getBoolean("level.junior");
                                if (junior)
                                    pref = sbpref.append("Junior High,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("level.senior")!=null){
                                Boolean senior = documentSnapshot.getBoolean("level.senior");
                                if (senior)
                                    pref = sbpref.append("Senior High,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("level.post_secondary")!=null){
                                Boolean postSec = documentSnapshot.getBoolean("level.post_secondary");
                                if (postSec)
                                    pref = sbpref.append("Post-secondary,  ").toString();
                            }
                            //other
                            if (documentSnapshot.getBoolean("other.meet_at_home")!=null){
                                Boolean meethome = documentSnapshot.getBoolean("other.meet_at_home");
                                if (meethome)
                                    pref = sbpref.append("Meet at home,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("other.meet_in_public")!=null){
                                Boolean meetpublic = documentSnapshot.getBoolean("other.meet_in_public");
                                if (meetpublic)
                                    pref = sbpref.append("Meet in public,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("other.french_immersion")!=null){
                                Boolean frenchIm = documentSnapshot.getBoolean("other.french_immersion");
                                if (frenchIm)
                                    pref = sbpref.append("French Immersion,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("other.slow_learner")!=null){
                                Boolean slowLearner = documentSnapshot.getBoolean("other.slow_learner");
                                if (slowLearner)
                                    pref = sbpref.append("Slow Learner,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("other.adhd_add")!=null){
                                Boolean adhd = documentSnapshot.getBoolean("other.adhd_add");
                                if (adhd)
                                    pref = sbpref.append("ADHD/ADD,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("other.hearing_impaired")!=null){
                                Boolean hearing = documentSnapshot.getBoolean("other.hearing_impaired");
                                if (hearing)
                                    pref = sbpref.append("Hearing Impaired,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("other.english_second_language")!=null){
                                Boolean esl = documentSnapshot.getBoolean("other.english_second_language");
                                if (esl)
                                    pref = sbpref.append("ESL,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("other.learning disability")!=null){
                                Boolean learnDisb = documentSnapshot.getBoolean("other.learning disability");
                                if (learnDisb)
                                    pref = sbpref.append("Learning Disability,  ").toString();
                            }

                            //AVAILABILITY
                            String days = "";
                            if (documentSnapshot.getBoolean("availability.monday")!=null){
                                Boolean mon = documentSnapshot.getBoolean("availability.monday");
                                if (mon)
                                    days = sbdays.append("Monday,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("availability.tuesday")!=null){
                                Boolean tues = documentSnapshot.getBoolean("availability.tuesday");
                                if (tues)
                                    days = sbdays.append("Tuesday,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("availability.wednesday")!=null){
                                Boolean wed = documentSnapshot.getBoolean("availability.wednesday");
                                if (wed)
                                    days = sbdays.append("Wednesday,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("availability.thursday")!=null){
                                Boolean thurs = documentSnapshot.getBoolean("availability.thursday");
                                if (thurs)
                                    days = sbdays.append("Thursday,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("availability.friday")!=null){
                                Boolean fri = documentSnapshot.getBoolean("availability.friday");
                                if (fri)
                                    days = sbdays.append("Friday,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("availability.saturday")!=null){
                                Boolean sat = documentSnapshot.getBoolean("availability.saturday");
                                if (sat)
                                    days = sbdays.append("Saturday,  ").toString();
                            }
                            if (documentSnapshot.getBoolean("availability.sunday")!=null){
                                Boolean sun = documentSnapshot.getBoolean("availability.sunday");
                                if (sun)
                                    days = sbdays.append("Sunday,  ").toString();
                            }

                            availability.setText("Availability:   " + days.substring(0,days.length()-3));  //.substring... removes the extra comma at end
                            preferences.setText("Preferences:   "+ pref.substring(0,pref.length()-3));
                            //END SETTING BIO

                        }
                        else{
                            //Toast.makeText(getContext(),"document does not exist",Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Toast.makeText(getContext(),"failure to read document",Toast.LENGTH_SHORT).show();
                    }
                });

        return view;
    }

}
