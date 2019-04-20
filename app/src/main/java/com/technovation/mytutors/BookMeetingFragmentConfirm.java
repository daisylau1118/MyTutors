package com.technovation.mytutors;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

public class BookMeetingFragmentConfirm extends DialogFragment {


    private String person;
    private String time;
    private String date;

    public BookMeetingFragmentConfirm() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        person = getArguments().getString("person");
        time = getArguments().getString("time");
        date = getArguments().getString("date");

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Book a meeting with " + person + " on "+ date +" at " + time + "?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Meeting Booked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel",null)
                .create();

        return dialog;
    }
}
