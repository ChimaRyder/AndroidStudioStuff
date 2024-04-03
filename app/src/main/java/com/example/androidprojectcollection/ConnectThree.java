package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ConnectThree extends AppCompatActivity {

    Button[][] buttons = new Button[5][5];

    Button btn1_1;
    Button btn1_2;
    Button btn1_3;
    Button btn1_4;
    Button btn1_5;

    Button btn2_1;
    Button btn2_2;
    Button btn2_3;
    Button btn2_4;
    Button btn2_5;

    Button btn3_1;
    Button btn3_2;
    Button btn3_3;
    Button btn3_4;
    Button btn3_5;

    Button btn4_1;
    Button btn4_2;
    Button btn4_3;
    Button btn4_4;
    Button btn4_5;

    Button btn5_1;
    Button btn5_2;
    Button btn5_3;
    Button btn5_4;
    Button btn5_5;

    int current_col;
    int[][] currentstate = new int[5][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_three);

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                String temp = "btn_" + (row+1) + "_" + (col+1);
                buttons[row][col] = findViewById(this.getResources().getIdentifier(temp, "id",this.getPackageName()));
            }
        }

        int[] currentsizes = new int[5];

       for (int i = 0 ; i < 5; i++) {
           for (int j = 0; j < 5; j++) {
               currentstate[i][j] = 0;
           }
       }

        for (int i = 0; i < 5; i++) {
            current_col = i;
           buttons[0][i].setOnClickListener(new View.OnClickListener() {
               int col = current_col;
               @Override
               public void onClick(View view) {
                  int target = 4;
                  while (currentstate[target][current_col] == 1) {
                      target--;
                  }
                  buttons[target][current_col].setBackgroundColor(android.R.color.black);
               }
           });
        }
    }
}