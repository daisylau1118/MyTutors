package com.technovation.mytutors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SavedPeopleFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private SavedPeopleRecyclerAdapter recyclerAdaper;
    private List<String> list;

    public SavedPeopleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_saved_people, container, false);

        list = Arrays.asList(getResources().getStringArray(R.array.users));
        recyclerView = view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdaper = new SavedPeopleRecyclerAdapter(list);
        recyclerView.setAdapter(recyclerAdaper);

        recyclerView.setHasFixedSize(true);
        return view;
    }

}
