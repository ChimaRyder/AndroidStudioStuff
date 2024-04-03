package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorMatch extends AppCompatActivity {

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button btnreturn;
    Button btnskip;

    Boolean isComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_match);

        //declare buttons
        one  = (Button) findViewById(R.id.one_one);
        two  = (Button) findViewById(R.id.one_two);
        three = (Button) findViewById(R.id.one_three);
        four  = (Button) findViewById(R.id.two_one);
        five = (Button) findViewById(R.id.two_two);
        six  = (Button) findViewById(R.id.two_three);
        seven  = (Button) findViewById(R.id.three_one);
        eight  = (Button) findViewById(R.id.three_two);
        nine  = (Button) findViewById(R.id.three_three);

        //add buttons to a list
        List<Button> colorButtons = new ArrayList<>();
        colorButtons.add(0, one);
        colorButtons.add(1, two);
        colorButtons.add(2, three);
        colorButtons.add(3, four);
        colorButtons.add(4, five);
        colorButtons.add(5, six);
        colorButtons.add(6, seven);
        colorButtons.add(7, eight);
        colorButtons.add(8, nine);

        List<Integer> colors = new ArrayList<>();
        colors.add(0, android.R.color.holo_red_dark);
        colors.add(1, android.R.color.holo_blue_dark);
        colors.add(2, android.R.color.holo_green_dark);

        int[] saved_Colors = new int[9];

        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            saved_Colors[i] = r.nextInt(3);
            colorButtons.get(i).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[i]), getTheme()));
            isComplete = false;
        }

        btnreturn = (Button) findViewById(R.id.btnreturn);

        btnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 9; i++) {
                    saved_Colors[i] = r.nextInt(3);
                    colorButtons.get(i).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[i]), getTheme()));
                }
            }
        });

        btnskip = (Button) findViewById(R.id.btnskip);

        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 9; i++) {
                    saved_Colors[i] = 0;
                    colorButtons.get(i).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[i]), getTheme()));
                }
            }
        });

        for (Button b : colorButtons) {
            int ID = colorButtons.indexOf(b) + 1;

            b.setOnClickListener(new View.OnClickListener() {
                int button_ID = ID;

                @Override
                public void onClick(View view) {
                    switch(button_ID) {
                        case 1:
                            if (saved_Colors[1] + 1 == 3) {
                                saved_Colors[1] = 0;
                            } else {
                                saved_Colors[1] = saved_Colors[1] + 1;
                            }

                            colorButtons.get(1).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[1]), getTheme()));

                            if (saved_Colors[3] + 1 == 3) {
                                saved_Colors[3] = 0;
                            } else {
                                saved_Colors[3] = saved_Colors[3] + 1;
                            }

                            colorButtons.get(3).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[3]), getTheme()));

                            break;

                        case 3:
                            if (saved_Colors[1] + 1 == 3) {
                                saved_Colors[1] = 0;
                            } else {
                                saved_Colors[1] = saved_Colors[1] + 1;
                            }

                            colorButtons.get(1).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[1]), getTheme()));

                            if (saved_Colors[5] + 1 == 3) {
                                saved_Colors[5] = 0;
                            } else {
                                saved_Colors[5] = saved_Colors[5] + 1;
                            }

                            colorButtons.get(5).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[5]), getTheme()));

                            break;

                        case 7:
                            if (saved_Colors[7] + 1 == 3) {
                                saved_Colors[7] = 0;
                            } else {
                                saved_Colors[7] = saved_Colors[7] + 1;
                            }

                            colorButtons.get(7).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[7]), getTheme()));

                            if (saved_Colors[3] + 1 == 3) {
                                saved_Colors[3] = 0;
                            } else {
                                saved_Colors[3] = saved_Colors[3] + 1;
                            }

                            colorButtons.get(3).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[3]), getTheme()));

                            break;

                        case 9:
                            if (saved_Colors[7] + 1 == 3) {
                                saved_Colors[7] = 0;
                            } else {
                                saved_Colors[7] = saved_Colors[7] + 1;
                            }

                            colorButtons.get(7).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[7]), getTheme()));

                            if (saved_Colors[5] + 1 == 3) {
                                saved_Colors[5] = 0;
                            } else {
                                saved_Colors[5] = saved_Colors[5] + 1;
                            }

                            colorButtons.get(5).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[5]), getTheme()));

                            break;

                        case 2:
                            if (saved_Colors[0] + 1 == 3) {
                                saved_Colors[0] = 0;
                            } else {
                                saved_Colors[0] = saved_Colors[0] + 1;
                            }

                            colorButtons.get(0).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[0]), getTheme()));

                            if (saved_Colors[2] + 1 == 3) {
                                saved_Colors[2] = 0;
                            } else {
                                saved_Colors[2] = saved_Colors[2] + 1;
                            }

                            colorButtons.get(2).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[2]), getTheme()));

                            if (saved_Colors[4] + 1 == 3) {
                                saved_Colors[4] = 0;
                            } else {
                                saved_Colors[4] = saved_Colors[4] + 1;
                            }

                            colorButtons.get(4).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[4]), getTheme()));

                            break;

                        case 4:
                            if (saved_Colors[0] + 1 == 3) {
                                saved_Colors[0] = 0;
                            } else {
                                saved_Colors[0] = saved_Colors[0] + 1;
                            }

                            colorButtons.get(0).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[0]), getTheme()));

                            if (saved_Colors[6] + 1 == 3) {
                                saved_Colors[6] = 0;
                            } else {
                                saved_Colors[6] = saved_Colors[6] + 1;
                            }

                            colorButtons.get(6).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[6]), getTheme()));

                            if (saved_Colors[4] + 1 == 3) {
                                saved_Colors[4] = 0;
                            } else {
                                saved_Colors[4] = saved_Colors[4] + 1;
                            }

                            colorButtons.get(4).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[4]), getTheme()));

                            break;

                        case 6:
                            if (saved_Colors[8] + 1 == 3) {
                                saved_Colors[8] = 0;
                            } else {
                                saved_Colors[8] = saved_Colors[8] + 1;
                            }

                            colorButtons.get(8).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[8]), getTheme()));

                            if (saved_Colors[2] + 1 == 3) {
                                saved_Colors[2] = 0;
                            } else {
                                saved_Colors[2] = saved_Colors[2] + 1;
                            }

                            colorButtons.get(2).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[2]), getTheme()));

                            if (saved_Colors[4] + 1 == 3) {
                                saved_Colors[4] = 0;
                            } else {
                                saved_Colors[4] = saved_Colors[4] + 1;
                            }

                            colorButtons.get(4).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[4]), getTheme()));

                            break;

                        case 8:
                            if (saved_Colors[8] + 1 == 3) {
                                saved_Colors[8] = 0;
                            } else {
                                saved_Colors[8] = saved_Colors[8] + 1;
                            }

                            colorButtons.get(8).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[8]), getTheme()));

                            if (saved_Colors[6] + 1 == 3) {
                                saved_Colors[6] = 0;
                            } else {
                                saved_Colors[6] = saved_Colors[6] + 1;
                            }

                            colorButtons.get(6).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[6]), getTheme()));

                            if (saved_Colors[4] + 1 == 3) {
                                saved_Colors[4] = 0;
                            } else {
                                saved_Colors[4] = saved_Colors[4] + 1;
                            }

                            colorButtons.get(4).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[4]), getTheme()));

                            break;

                        case 5:
                            if (saved_Colors[1] + 1 == 3) {
                                saved_Colors[1] = 0;
                            } else {
                                saved_Colors[1] = saved_Colors[1] + 1;
                            }

                            colorButtons.get(1).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[1]), getTheme()));

                            if (saved_Colors[3] + 1 == 3) {
                                saved_Colors[3] = 0;
                            } else {
                                saved_Colors[3] = saved_Colors[3] + 1;
                            }

                            colorButtons.get(3).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[3]), getTheme()));

                            if (saved_Colors[5] + 1 == 3) {
                                saved_Colors[5] = 0;
                            } else {
                                saved_Colors[5] = saved_Colors[5] + 1;
                            }

                            colorButtons.get(5).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[5]), getTheme()));

                            if (saved_Colors[7] + 1 == 3) {
                                saved_Colors[7] = 0;
                            } else {
                                saved_Colors[7] = saved_Colors[7] + 1;
                            }

                            colorButtons.get(7).setBackgroundColor(getResources().getColor(colors.get(saved_Colors[7]), getTheme()));

                            break;
                    }
                }
            });


        }
    }
}
