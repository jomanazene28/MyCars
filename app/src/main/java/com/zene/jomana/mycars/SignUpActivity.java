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
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private EditText etRePassword;
    private Button btnSignUp;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        etRePassword=(EditText)findViewById(R.id.etRePassword);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        eventHandler();
        auth = FirebaseAuth.getInstance();
    }

    public void dataHandler(){
        String stEmail=etEmail.getText().toString();
        String stPassword=etPassword.getText().toString();
        String stRePassword=etRePassword.getText().toString();

        boolean isOk=true;
        if (stEmail.length() == 0) {
            etEmail.setError("Wrong Email");
            isOk = false;
        }

        if (stPassword.length() == 0) {
            etPassword.setError("Wrong password");
            isOk = false;
        }
        if (stRePassword.length() == 0){
            etRePassword.setError("Wrong Password");
            isOk = false;
        }
        if(isOk)
            creatAcount(stEmail,stPassword);

    }

    public void eventHandler(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignUpActivity.this,FirstActivity.class);
                startActivity(i);
                dataHandler();
            }
        });
    }

    private FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user=firebaseAuth.getCurrentUser();
            if (user!=null)

                Toast.makeText(SignUpActivity.this,"user is signed in.",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(SignUpActivity.this,"user signed out",Toast.LENGTH_SHORT).show();





        }


    };
    protected void onStart(){
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }
    protected void onStop(){
        super.onStop();
        if (authStateListener!=null)
            auth.removeAuthStateListener(authStateListener);
    }

    private void creatAcount(String email,String passw){
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {
                    Toast.makeText(SignUpActivity.this,"Authentication Successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(SignUpActivity.this,"Authentication failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }

            }
        });

    }

}
