package com.technovation.mytutors;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btnNextScreen;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnNextScreen = findViewById(R.id.btn_sign_up_to_main);
        btnNextScreen.setOnClickListener(this);
    }

    public void onClick (View v)
    {
        startActivity(new Intent(this,MainActivity.class));
    }

}
