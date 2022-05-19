package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_2);

            EditText amzius = (EditText) findViewById(R.id.amzius);
            String Amzius = amzius.getText().toString();

            EditText turimasuma = (EditText) findViewById(R.id.turimasuma);
            String Turimasuma = turimasuma.getText().toString();

        }
    public void radioButtonhandler(View view) {

        // Decide what happens when a user clicks on a button
    }
    public void submitbuttonHandler(View view) {

      Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}