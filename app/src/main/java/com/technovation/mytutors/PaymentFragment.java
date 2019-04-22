package com.technovation.mytutors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaymentFragment extends Fragment implements View.OnClickListener {


    private Button confirm;
    private Button bookMeeting;
    private EditText editPayment;
    private EditText editPerson;
    private double payment = 0.00;
    //private String paymentstr;


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
        bookMeeting.setOnClickListener(this);

        editPayment = view.findViewById(R.id.editPayment);
        editPerson = view.findViewById(R.id.editPerson);
        //paymentstr = editPayment.getText().toString();

        if ((editPayment.getText().toString())!=null && (editPayment.getText().toString()).length() > 0)
            payment = Double.parseDouble(editPayment.getText().toString());




        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm:
                PaymentFragmentConfirm confirm = new PaymentFragmentConfirm();

                Bundle args = new Bundle();
                args.putString("person", editPerson.getText().toString());
                //args.putString("testPayment",paymentstr);
                args.putDouble("payment",payment);
                confirm.setArguments(args);

                confirm.show(getFragmentManager(), "comms");
                break;
            case R.id.book_meeting_btn :
                MainActivity.fragmentManager.beginTransaction().replace(R.id.FragmentContainer,new BookMeetingFragment(), null).addToBackStack(null).commit();
                break;
        }
    }

}
