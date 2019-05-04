package com.technovation.mytutors;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
    private DocumentReference nameRef = db.collection("users").document(currentUser);

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
