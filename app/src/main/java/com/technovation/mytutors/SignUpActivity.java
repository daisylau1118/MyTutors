package com.technovation.mytutors;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener, OnCompleteListener<AuthResult>
{
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String currentUser;

    private Button btnNextScreen;
    private EditText etFirstName, etLastName, etEmail, etPassword, etRetypePassword;

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        currentUser = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

        btnNextScreen = findViewById(R.id.btn_sign_up_to_main);
        btnNextScreen.setOnClickListener(this);

        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etRetypePassword = findViewById(R.id.et_retype_password);
    }

    public void onClick (View v)
    {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String retype_password = etRetypePassword.getText().toString();
        CollectionReference users = db.collection("users");

        if (!firstName.isEmpty()
            && !lastName.isEmpty()
            && !password.isEmpty()
            && Patterns.EMAIL_ADDRESS.matcher(email).matches()
            && password.equals(retype_password))
        {
            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, this);

            /*users.document(currentUser).update("first_name", firstName);
            users.document(currentUser).update("last_name", lastName);*/
        }
    }


    @Override
    public void onComplete(@NonNull Task<AuthResult> task)
    {
        if (task.isSuccessful())
        {
            FirebaseUser user = mAuth.getCurrentUser();
            Log.d("Firebase User", user.getDisplayName() + user.getEmail());
            startActivity(new Intent(this,MainActivity.class));
        }else
        {
            Toast.makeText(this,"Failed to create user", Toast.LENGTH_SHORT).show();
        }
    }
}
