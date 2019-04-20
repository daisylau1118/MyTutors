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
public class ViewProfileFragment extends Fragment {

    private ImageButton Chat;
    private ImageButton BookMeeting;
    private ImageButton payment;
    private Button seeMore;

    public ViewProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_viewing_profile, container, false);


        // changing fragment to chat if chat icon is clicked
        Chat = (ImageButton)view.findViewById(R.id.goToChat);
        Chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new ChatFragment(), null).addToBackStack(null).commit();
            }
        });
        // changing fragment to book meeting if calender icon is clicked
        BookMeeting = (ImageButton)view.findViewById(R.id.goToCalender);
        BookMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new BookMeetingFragment(), null).addToBackStack(null).commit();
            }
        });

        // changing fragment to payment if pay icon is clicked
        payment = (ImageButton)view.findViewById(R.id.goToPayment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new PaymentFragment(), null).addToBackStack(null).commit();
            }
        });

        // changing fragment to see more reviews if see more button clicked
        seeMore = view.findViewById(R.id.see_more_btn);
        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new MyRatingsFragment(), null).addToBackStack(null).commit();
            }
        });



        return view;
    }

}
