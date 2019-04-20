package com.technovation.mytutors;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookMeetingFragment extends DialogFragment implements View.OnClickListener{

    private Button confirm;

    public BookMeetingFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_book_meeting, container, false);
        confirm = view.findViewById(R.id.confirm_btn);
        confirm.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        new BookMeetingFragmentConfirm().show(getFragmentManager(), "comms");
    }






}
