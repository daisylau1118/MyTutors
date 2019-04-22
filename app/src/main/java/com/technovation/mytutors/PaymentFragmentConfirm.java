package com.technovation.mytutors;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragmentConfirm extends DialogFragment {


    public PaymentFragmentConfirm() {
        // Required empty public constructor
    }

    private Double payment;
    private String person;
    //private String testPayment;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        person = getArguments().getString("person");
        payment = getArguments().getDouble("payment");
        //testPayment = getArguments().getString("testPayment");


        Dialog dialog = new AlertDialog.Builder(getActivity())
            .setTitle("Make a payment of $"+ payment +" to " + person + "?\nYour booking fee is $" +payment*0.01 )
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Payment confirmed", Toast.LENGTH_SHORT).show();
                    }
                })
            .setNegativeButton("Cancel",null)
            .create();

        return dialog;
    }





}
