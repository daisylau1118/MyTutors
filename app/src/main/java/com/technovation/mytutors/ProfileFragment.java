package com.technovation.mytutors;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private Button myProfile;
    private Button myHistory;
    private Button myRatings;
    private Button savedPeople;

    private TextView userName;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
    private DocumentReference nameRef = db.collection("users").document(currentUser);


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);


        // changing fragment to myProfile if My profile is clicked
        myProfile = view.findViewById(R.id.goToMyProfile);
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new MyProfileFragment(), null).addToBackStack(null).commit();
            }
        });

        // changing fragment to myHistory if My History is clicked
        myHistory = view.findViewById(R.id.goToMyHistory);
        myHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new MyHistoryFragment(), null).addToBackStack(null).commit();
            }
        });

        // changing fragment to myRatings if My Ratings is clicked
        myRatings = view.findViewById(R.id.goToMyRatings);
        myRatings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new MyRatingsFragment(), null).addToBackStack(null).commit();
            }
        });

        // changing fragment to savedPeople if savedPeople is clicked
        savedPeople = view.findViewById(R.id.goToSavedPeople);
        savedPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new SavedPeopleFragment(), null).addToBackStack(null).commit();
            }
        });


        userName = view.findViewById(R.id.userName);
        nameRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            String first = documentSnapshot.getString("first_name");
                            String last = documentSnapshot.getString("last_name");
                            userName.setText(first + " "+ last);

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





}
