package com.example.as_lab;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView Title;
    private EditText Email;
    private EditText Password;
    private Button SI;
    private Button SU;

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
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        if (view == SU) {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}
