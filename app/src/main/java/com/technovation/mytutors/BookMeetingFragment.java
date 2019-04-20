package com.technovation.mytutors;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookMeetingFragment extends DialogFragment implements View.OnClickListener{

    private Button confirm;
    private ImageButton payment;

    private EditText person;
    private EditText time;
    OnMessageReadListener messageReadListener;


    public BookMeetingFragment() {
        // Required empty public constructor
    }

    public interface OnMessageReadListener{

        public void onMessageRead(String person);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_book_meeting, container, false);

        // if user presses confirm popup will ask to confirm again
        confirm = view.findViewById(R.id.confirm_btn);
        confirm.setOnClickListener(this);


        // if user presses payment button they will be taken to payment fragment
        payment= (ImageButton)view.findViewById(R.id.pay_btn);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new PaymentFragment(), null).addToBackStack(null).commit();
            }
        });


        //person = view.findViewById(R.id.editPerson);
        //time = view.findViewById(R.id.editTime);

        return view;
    }

    @Override
    public void onClick(View v) {
        new BookMeetingFragmentConfirm().show(getFragmentManager(), "comms");
    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity)context;

        try{
            messageReadListener = (OnMessageReadListener)activity;
        }catch (ClassCastException e)
        {
            throw ClassCastException(activity.toString()+ "must overide onMessageRead...")
        }
    }
    */
}
