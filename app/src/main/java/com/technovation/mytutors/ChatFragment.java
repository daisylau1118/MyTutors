package com.technovation.mytutors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    private ImageButton profile;
    private ImageButton myProfile;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_chat, container, false);

        // clicking on profile pic of person youre chatting with will take you to their profile
        profile= (ImageButton)view.findViewById(R.id.profile_btn);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new ViewProfileFragment(), null).addToBackStack(null).commit();
            }
        });

        //taking user to their own profile when they click their profile pic
        myProfile= (ImageButton)view.findViewById(R.id.user_profile_btn);
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new MyProfileFragment(), null).addToBackStack(null).commit();
            }
        });
        return view;
    }


}
