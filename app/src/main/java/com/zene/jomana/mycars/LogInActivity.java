package com.zene.jomana.mycars;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogIn;
    private Button btnSignUp;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnLogIn=(Button)findViewById(R.id.btnLogIn);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        auth=FirebaseAuth.getInstance();
        eventHandler();
    }
    public void dataHandler(){
        String stEmail=etEmail.getText().toString();
        String stPassword=etPassword.getText().toString();
        boolean isOk = true;
        if (stEmail.length() == 0) {
            etEmail.setError("Wrong Email");
            isOk = false;
            //54456465
        }
        if (stPassword.length() == 0) {
            etPassword.setError("Wrong Password");
            isOk = false;
        }
        if (isOk)
            signIn(stEmail, stPassword);

    }

    public void eventHandler(){
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           dataHandler();

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LogInActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }

    private void signIn(String email,String passw){
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(LogInActivity.this,"signIn Successful",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(LogInActivity.this,ShareActivity.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(LogInActivity.this,"signIn faild"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });

    }
}
