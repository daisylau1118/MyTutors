package com.technovation.mytutors;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener, OnCompleteListener<AuthResult>
{
    private FirebaseAuth mAuth;
    private Button  btnLogin;
    private Button btnCreateAccount;
    private EditText etName, etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        btnLogin = findViewById(R.id.btn_login);
        btnCreateAccount = findViewById(R.id.btn_create_account);

        btnLogin.setOnClickListener(this);
        btnCreateAccount.setOnClickListener(this);

        etName = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null)
        {
            //mAuth.signOut();
            Toast.makeText(this, user.getEmail(),Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn_login:
                String name = etName.getText().toString();
                String password = etPassword.getText().toString();

                if (!name.isEmpty()
                    && !password.isEmpty())
                {
                    mAuth.signInWithEmailAndPassword(name,password).addOnCompleteListener(this);
                }
                break;
            case R.id.btn_create_account:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
        }
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task)
    {
        if (task.isSuccessful())
        {
            startActivity(new Intent(this, MainActivity.class));
        }else
        {
            Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
        }

    }

    public static class User
    {
        public String first_name;
        public String last_name;
        public String description;
        public String[] questionaire;

        public User (String first_name, String last_name, String description, String[] questionaire)
        {
            this.first_name = first_name;
            this.last_name = last_name;
            this.description = description;
            this.questionaire = questionaire;
        }
    }

}
