package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2;
    ProgressBar bar;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


            t1 = (EditText) findViewById(R.id.username);
            t2 = (EditText) findViewById(R.id.password);
            bar = (ProgressBar) findViewById(R.id.progressBar);

    }

    public void signuphere(View view) {

        bar.setVisibility(View.VISIBLE);
        String email = t1.getText().toString();
        String password = t2.getText().toString();
      //  Toast.makeText(getApplicationContext(),"email: "+email+"Pass: "+password,Toast.LENGTH_LONG).show();
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            bar.setVisibility(View.INVISIBLE);
                            t1.setText("");
                            t2.setText("");

                            Toast.makeText(getApplicationContext(),"Registration Succesfull",Toast.LENGTH_LONG).show();

                        }
                        else {

                            bar.setVisibility(View.INVISIBLE);
                            t1.setText("");
                            t2.setText("");
                            Toast.makeText(getApplicationContext(),"Process Error",Toast.LENGTH_LONG).show();
                        }


                    }
                });
    }
}