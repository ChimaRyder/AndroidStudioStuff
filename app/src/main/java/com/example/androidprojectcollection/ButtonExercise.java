package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class ButtonExercise extends AppCompatActivity {

    Button anotheractivity;
    Button toast;
    Button background;
    Button buttonbackground;
    Button disappear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);

        anotheractivity = (Button) findViewById(R.id.btnactivity);
        anotheractivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        ButtonExercise.this,
                        AnotherActivity.class);
                startActivity(intent);
            }
        });

        toast = (Button) findViewById(R.id.btntoast);
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "This is a toast message!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        });

        background = (Button) findViewById(R.id.btnbg);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                ConstraintLayout ll = (ConstraintLayout) findViewById(R.id.btnexbg);
                ll.setBackgroundColor(rnd.nextInt());
            }
        });

        buttonbackground = (Button) findViewById(R.id.btnbuttonbg);
        buttonbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                view.setBackgroundColor(rnd.nextInt());
            }
        });

        disappear = (Button) findViewById(R.id.btndisappear);
        disappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
            }
        });
    }
}