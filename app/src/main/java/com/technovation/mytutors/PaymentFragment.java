package com.technovation.mytutors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment implements View.OnClickListener {


    private Button confirm;
    private Button bookMeeting;

    public PaymentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =  inflater.inflate(R.layout.fragment_payment, container, false);
            confirm = view.findViewById(R.id.confirm);
            confirm.setOnClickListener(this);

        bookMeeting = view.findViewById(R.id.book_meeting_btn);
        bookMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new BookMeetingFragment(), null).addToBackStack(null).commit();
            }
        });


        return view;
    }


    @Override
    public void onClick(View v) {
        new PaymentFragmentConfirm().show(getFragmentManager(), "comms");
    }
}
