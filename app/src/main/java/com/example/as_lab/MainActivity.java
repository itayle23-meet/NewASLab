package com.example.as_lab;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Title;
    private EditText Email;
    private EditText Password;
    private Button SI;
    private Button SU;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Title = findViewById(R.id.Title);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        SI = findViewById(R.id.SI);
        SU = findViewById(R.id.SU);
        SI.setOnClickListener(this);
        SU.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == SI) {
            signin_user(Email.getText().toString(),Password.getText().toString());
        }
        if (view == SU) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
    }
    public void signin_user(String Email,String Password){
        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                }
                else {
                    Toast.makeText(MainActivity.this,"Authentication failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
