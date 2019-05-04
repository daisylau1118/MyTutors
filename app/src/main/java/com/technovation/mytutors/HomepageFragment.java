package com.technovation.mytutors;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        db = FirebaseFirestore.getInstance();

        db.collection("tutors")
                .whereEqualTo("availability.monday", true)
                .get()
                .addOnCompleteListener(this);


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
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer, new ViewProfileFragment(), null).addToBackStack(null).commit();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) { }
                }));

        return view;
    }

    @Override
    public void onComplete(@NonNull Task<QuerySnapshot> task) {
        list = new ArrayList<>();

        if (task.isSuccessful()) {
            for (QueryDocumentSnapshot document : task.getResult()) {
                document.getDocumentReference("user")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot data = task.getResult();
                                    String firstName = data.getString("first_name");
                                    String lastName = data.getString("last_name");
                                    if (firstName != null && lastName != null) {
                                        list.add(firstName + " " + lastName + ",pic1,4.5");
                                        Log.d("Firebase", "Firebase Username: " + data.getString("first_name"));

                                        recyclerAdaper.setList(list);
                                        recyclerAdaper.notifyDataSetChanged();
                                    }

                                }
                            }
                        });
            }
        } else {
            Log.d("Firebase", "Error getting document: ", task.getException());
        }
    }
}
