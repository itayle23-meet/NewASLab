package com.example.as_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView Title;
    private ListView newListView;
    private ArrayList<User> User;
    private ArrayAdapter<User> UserArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Title = findViewById(R.id.Title);
        newListView = findViewById(R.id.newListView);
        User = new ArrayList<>();
        User.add(new User("itay","itay@gmail.com","123"));
        User.add(new User("udi","udi@gmail.com","321"));
        UserArrayAdapter = new UserArrayAdapter(this,R.layout.new_custom_row,User);
        newListView.setAdapter(UserArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.SO){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }
}