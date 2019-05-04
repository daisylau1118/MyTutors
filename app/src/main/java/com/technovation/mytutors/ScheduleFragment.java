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
    private Button edit;

    private TextView date;
    private CalendarView calender;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, MMM d");
    private String selectedDate;
    private Date tempdate;

    private TextView dateInfo;
    private String description;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        //book meeting button to book meeting fragment
        bookMeeting= view.findViewById(R.id.book_meeting_btn);
        bookMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new BookMeetingFragment(), null).addToBackStack(null).commit();
            }
        });

        //edit meeting button to book meeting
        edit = view.findViewById(R.id.edit_btn);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new BookMeetingFragment(), null).addToBackStack(null).commit();
            }
        });



        date = view.findViewById(R.id.date);
        calender = view.findViewById(R.id.calendarView);
        dateInfo = view.findViewById(R.id.date_info);

        //changing the date to match selected date
        // if user selects another date
        calender.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                try {
                    // changing year,month,day ints to string then to date
                    // for some reason month is one less than it's supposed to be?? so I added one to show the correct month
                    tempdate = new SimpleDateFormat("dd/MM/yyyy").parse(dayOfMonth+ "/"+ (month+1) + "/"+ year);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //changing date back to string in desired format
                selectedDate = simpleDateFormat.format(tempdate);
                date.setText(selectedDate.replaceAll("\\.", ""));

                //changing the info under date to match selected date
                if (selectedDate.equals("Mon., May 6")) //temp-- get booking info from database later
                    dateInfo.setText("• 11:00am: Meet Emma at library");
                else if ((selectedDate.equals("Fri., May 10")))
                    dateInfo.setText("• 3:00pm: Meeting with John at cafe");
                else if ((selectedDate.equals("Tue., May 7")))
                    dateInfo.setText("• 6:00pm: Tutoring with Emma at school");
                else if ((selectedDate.equals("Sat., May 4")))
                    dateInfo.setText("• 6:00pm: Technovation :)");
                else
                    dateInfo.setText("• no events");

            }//met
        });
        // user stays on current date
        if (tempdate == null){
            selectedDate = simpleDateFormat.format(new Date(calender.getDate()));
            date.setText(selectedDate);

            //changing the info under date to match selected date
            if (selectedDate.equals("Mon, Apr 22")) //temp-- get booking info from database later
                dateInfo.setText("• 11:00am: Meet Emma at library");
            else if ((selectedDate.equals("Fri, Apr 26")))
                dateInfo.setText("• 3:00pm: Meeting with John at cafe");
            else if ((selectedDate.equals("Tue, Apr 30")))
                dateInfo.setText("• 6:00pm: Tutoring with Emma at school");
            else
                dateInfo.setText("• no events");
        }












        return view;
    }



}
