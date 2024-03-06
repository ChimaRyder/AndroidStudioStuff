package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator extends AppCompatActivity {

    TextView result;
    TextView lastnum;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;

    Button add;
    Button subtract;
    Button multiply;
    Button divide;
    Button equals;
    Button point;
    boolean hasChanged = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().hide();


        result = (TextView) findViewById(R.id.result_textview);

        zero = (Button) findViewById(R.id.button_zero);
        one = (Button) findViewById(R.id.button_one);
        two = (Button) findViewById(R.id.button_two);
        three = (Button) findViewById(R.id.button_three);
        four = (Button) findViewById(R.id.button_four);
        five = (Button) findViewById(R.id.button_five);
        six = (Button) findViewById(R.id.button_six);
        seven = (Button) findViewById(R.id.button_seven);
        eight = (Button) findViewById(R.id.button_eight);
        nine = (Button) findViewById(R.id.button_nine);

        List<Button> buttons = new ArrayList<>();
        buttons.add(zero);
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);
        buttons.add(six);
        buttons.add(seven);
        buttons.add(eight);
        buttons.add(nine);

        for (Button b : buttons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button x = (Button) view;
                    String num = x.getText().toString();

                    if (result.getText().equals("0") || !hasChanged){
                        result.setText(num);
                        hasChanged = true;
                    } else {
                        result.setText(result.getText() + num);
                    }
                }
            });
        }

        point = (Button) findViewById(R.id.button_point);
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button y = (Button) view;
                String p = y.getText().toString();

                if (!result.getText().toString().contains(".")){
                    result.setText(result.getText() + p);
                }
            }
        });

        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        equals = (Button) findViewById(R.id.equals);

        List<Button> ops = new ArrayList<>();
        ops.add(add);
        ops.add(subtract);
        ops.add(multiply);
        ops.add(divide);
        ops.add(equals);

        lastnum = (TextView) findViewById(R.id.lastnum_textview);

        Stack<String> calculation = new Stack<>();
        for (Button b : ops) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button o = (Button) view;
                    String operator = o.getText().toString();

                    switch(operator) {
                        case "+":
                            if(hasChanged) {
                                lastnum.setText(lastnum.getText().toString() + result.getText().toString() + " + ");
                                calculation.push(result.getText().toString());
                                calculation.push("+");
                                hasChanged = false;
                            } else {
                                lastnum.setText(lastnum.getText().toString().substring(0, lastnum.getText().length()-3) + " + ");
                                calculation.pop();
                                calculation.push("+");
                            }
                            break;
                        case "-":
                            if(hasChanged) {
                                lastnum.setText(lastnum.getText().toString() + result.getText().toString() + " - ");
                                calculation.push(result.getText().toString());
                                calculation.push("-");
                                hasChanged = false;
                            }else {
                                lastnum.setText(lastnum.getText().toString().substring(0, lastnum.getText().length()-3) + " - ");
                                calculation.pop();
                                calculation.push("-");
                            }
                            break;
                        case "*":
                            if (hasChanged) {
                                lastnum.setText(lastnum.getText().toString() + result.getText().toString() + " * ");
                                calculation.push(result.getText().toString());
                                calculation.push("*");
                                hasChanged = false;
                            } else {
                                lastnum.setText(lastnum.getText().toString().substring(0, lastnum.getText().length()-3) + " * ");
                                calculation.pop();
                                calculation.push("*");
                            }
                            break;
                        case "/":
                            if (hasChanged) {
                                lastnum.setText(lastnum.getText().toString() + result.getText().toString() + " / ");
                                calculation.push(result.getText().toString());
                                calculation.push("/");
                                hasChanged = false;
                            } else {
                                lastnum.setText(lastnum.getText().toString().substring(0, lastnum.getText().length()-3) + " / ");
                                calculation.pop();
                                calculation.push("/");
                            }
                            break;

                    }
                }
            });
        }


    }
}