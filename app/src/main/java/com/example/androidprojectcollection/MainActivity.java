package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button layoutButton;
    Button buttonExercise;
    Button calcbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutButton = (Button) findViewById(R.id.btnLayoutExercise);
        layoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        LayoutExercise.class);
                startActivity(intent);
            }
        });

        buttonExercise = (Button) findViewById(R.id.button2);
        buttonExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        ButtonExercise.class);
                startActivity(intent);
            }
        });

        calcbutton = (Button) findViewById(R.id.button3);
        calcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        MainActivity.this,
                        Calculator.class);
                startActivity(intent);
            }
        });
    }
}