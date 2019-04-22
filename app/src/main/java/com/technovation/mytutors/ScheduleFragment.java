package com.technovation.mytutors;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.support.constraint.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private Button bookMeeting;
    private TextView date;
    private CalendarView calender;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
    private String selectedDate;
    private Date tempdate;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        bookMeeting= view.findViewById(R.id.book_meeting_btn);
        bookMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new BookMeetingFragment(), null).addToBackStack(null).commit();
            }
        });

        date = view.findViewById(R.id.date);
        calender = view.findViewById(R.id.calendarView);

        //date.setText(calender.getDate());

        //simpleDateFormat.format(new Date(calender.getDate()));
        // if user selects another date
        calender.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
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
            selectedDate = simpleDateFormat.format(new Date(calender.getDate()));

        date.setText(selectedDate);


        return view;
    }



}
