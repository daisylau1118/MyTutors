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
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookMeetingFragment extends Fragment implements View.OnClickListener {

    private Button confirm;
    private ImageButton payment;

    private EditText editPerson;
    private EditText editTime;
    private CalendarView editDate;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
    private String selectedDate;
    private Date tempdate;



    public BookMeetingFragment() {
        // Required empty public constructor
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
        payment.setOnClickListener(this);


        editPerson = view.findViewById(R.id.editPerson);
        editTime = view.findViewById(R.id.editTime);
        editDate = view.findViewById(R.id.calendarView);

        // if user selects another date
        editDate.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                try {
                    // changing year,month,day ints to string then to date
                    tempdate = new SimpleDateFormat("dd/MM/yyyy").parse(dayOfMonth+ "/"+ month + "/"+ year);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //changing date back to string in desired format
                selectedDate = simpleDateFormat.format(tempdate);

            }//met
        });
        // user stays on current date
        if (tempdate == null)
            selectedDate = simpleDateFormat.format(new Date(editDate.getDate()));

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm_btn:
                BookMeetingFragmentConfirm confirm = new BookMeetingFragmentConfirm();

                Bundle args = new Bundle();
                args.putString("person", editPerson.getText().toString());
                args.putString("time",editTime.getText().toString());
                args.putString("date",selectedDate);
                confirm.setArguments(args);

                confirm.show(getFragmentManager(), "comms");
                break;
            case R.id.pay_btn:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new PaymentFragment(), null).addToBackStack(null).commit();
                break;
        }

    }
}
