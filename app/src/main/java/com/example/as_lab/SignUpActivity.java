package com.example.as_lab;

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
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Title;
    private EditText Email;
    private EditText Password;
    private EditText Name;
    private Button SumbitBtn;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        setContentView(R.layout.activity_sign_up);
        Title = findViewById(R.id.Title);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Name = findViewById(R.id.Name);
        SumbitBtn = findViewById(R.id.SumbitBtn);
        SumbitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==SumbitBtn){
            create_user(Email.getText().toString(),Password.getText().toString());
        }
    }
    public void create_user(String Email,String Password){
        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    User user = new User(Name.getText().toString(),Email.toString(),Password.toString());
                    String uid = mAuth.getCurrentUser().getUid().toString();
                    database.getReference("Users").child(uid).setValue(user);
                    Intent i = new Intent(SignUpActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(SignUpActivity.this,"Authentication failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}