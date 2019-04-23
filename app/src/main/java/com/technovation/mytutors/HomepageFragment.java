package com.technovation.mytutors;


import android.media.MediaDrm;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomepageFragment extends Fragment implements OnCompleteListener<QuerySnapshot> {

    private Button profileCard;
    private Button settings;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HomepageRecyclerAdapter recyclerAdaper;
    private List<String> list;

    private FirebaseFirestore db;
    private EditText etSearchBar;
    private List<String> searchFilteredUserID;

    public HomepageFragment() {
        // Required empty public constructor
    }

    /*@Override
    public void onCreate (@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        db = FirebaseFirestore.getInstance();

        searchFilteredUserID = new ArrayList<>();
        db.collection("tutors")
                .whereEqualTo("availability.monday", true)
                .get()
                .addOnCompleteListener(this);

        for (String uid: searchFilteredUserID)
        {
            db.collection("users").document(uid).addSnapshotListener(new EventListener<DocumentSnapshot>()
            {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e)
                {
                   if (e != null)
                   {
                       Log.d(TAG, "Listened failed.", e);
                       return;
                   }

                   if (documentSnapshot != null && documentSnapshot.exists())
                   {
                       Log.d(TAG, "Name: " + documentSnapshot.getString("first_name") + documentSnapshot.getString("last_name"));
                   }
                   else
                   {
                       Log.d(TAG, "No data");
                   }
                }
            });
        }

        /*




        // changing fragment to settings if settings is clicked
        settings= view.findViewById(R.id.settingsButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new SettingsFragment(), null).addToBackStack(null).commit();
            }
        });
        */


        list = Arrays.asList(getResources().getStringArray(R.array.users));
        recyclerView = view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdaper = new HomepageRecyclerAdapter(list);
        recyclerView.setAdapter(recyclerAdaper);

        recyclerView.setHasFixedSize(true);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                                                getContext(),
                                                recyclerView,
                                                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new ViewProfileFragment(), null).addToBackStack(null).commit();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }



        }));

        return view;
    }

    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task)
    {
        if (task.isSuccessful())
        {
            for (QueryDocumentSnapshot document: task.getResult())
            {
                searchFilteredUserID.add(document.getId());
                Log.d(TAG,"Firebase User: " + searchFilteredUserID);
            }
        }else
        {
            Log.d(TAG,"Error getting document: ", task.getException());
        }
    }
}
