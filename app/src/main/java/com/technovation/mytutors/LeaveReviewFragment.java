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
public class LeaveReviewFragment extends Fragment implements View.OnClickListener{

    private Button confirm;

    public LeaveReviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leave_review, container, false);
        confirm = view.findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        new LeaveReviewFragmentConfirm().show(getFragmentManager(), "comms");
    }

}
