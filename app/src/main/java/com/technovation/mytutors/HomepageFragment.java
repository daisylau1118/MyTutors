package com.technovation.mytutors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomepageFragment extends Fragment {

    private Button profileCard;
    private Button settings;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private HomepageRecyclerAdapter recyclerAdaper;
    private List<String> list;


    public HomepageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

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

}
