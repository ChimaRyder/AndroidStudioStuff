package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Calendar;

public class PassingIntentsExercise extends AppCompatActivity {

    private EditText FName;
    private EditText LName;

    private RadioButton Male;
    private RadioButton Female;
    private RadioButton Others;
    private EditText Birthdate;
    private EditText PhoneNumber;
    private EditText Email;
    private EditText Address;

    private EditText Department;
    private EditText Program;
    private RadioButton Year1;
    private RadioButton Year2;
    private RadioButton Year3;
    private RadioButton Year4;
    private RadioButton Year5;

    private Button Clear;
    private Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        FName = (EditText) findViewById(R.id.tfFName);
        LName = (EditText) findViewById(R.id.tfLName);

        Male = (RadioButton) findViewById(R.id.rbMale);
        Female = (RadioButton) findViewById(R.id.rbFemale);
        Others = (RadioButton) findViewById(R.id.rbOthers);

        PhoneNumber = (EditText) findViewById(R.id.tfPhone);
        Email = (EditText) findViewById(R.id.tfEmail);
        Address = (EditText) findViewById(R.id.tfAddress);

        Department = (EditText) findViewById(R.id.tfDepartment);
        Program = (EditText) findViewById(R.id.tfProgram);

        Year1 = (RadioButton) findViewById(R.id.rb1);
        Year2 = (RadioButton) findViewById(R.id.rb2);
        Year3 = (RadioButton) findViewById(R.id.rb3);
        Year4 = (RadioButton) findViewById(R.id.rb4);
        Year5 = (RadioButton) findViewById(R.id.rb5);

        Clear = (Button) findViewById(R.id.btnClear);
        Submit = (Button) findViewById(R.id.btnSubmit);

        Birthdate = (EditText) findViewById(R.id.tfBirthdate);
        Calendar c = Calendar.getInstance();
        int cday = c.get(Calendar.DAY_OF_MONTH);
        int cmonth = c.get(Calendar.MONTH);
        int cyear = c.get(Calendar.YEAR);

        Birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dpd = new DatePickerDialog(PassingIntentsExercise.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Birthdate.setText(String.valueOf(month+1) + "/" + String.valueOf(day) + "/" + String.valueOf(year));
                    }
                }, cyear, cmonth, cday);
                dpd.show();
            }
        });

        Birthdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    DatePickerDialog dpd = new DatePickerDialog(PassingIntentsExercise.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            Birthdate.setText(String.valueOf(month+1) + "/" + String.valueOf(day) + "/" + String.valueOf(year));
                        }
                    }, cyear, cmonth, cday);
                    dpd.show();
                }
            }
        });

        ArrayList<RadioButton> genders = new ArrayList<>();
        genders.add(Male);
        genders.add(Female);
        genders.add(Others);

        ArrayList<RadioButton> years = new ArrayList<>();
        years.add(Year1);
        years.add(Year2);
        years.add(Year3);
        years.add(Year4);
        years.add(Year5);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f = FName.getText().toString();
                String l = LName.getText().toString();

                String gender = "";
                for (RadioButton r : genders) {
                    if (r.isChecked()) {
                       gender = r.getText().toString();
                       break;
                    }
                }

                String birthdate = Birthdate.getText().toString();
                String phone = PhoneNumber.getText().toString();
                String email = Email.getText().toString();
                String address = Address.getText().toString();

                String dept = Department.getText().toString();
                String program = Program.getText().toString();

                String year = "";
                for (RadioButton r : years) {
                    if (r.isChecked()) {
                        year = r.getText().toString();
                        break;
                    }
                }

                //Make intent and put data in intent
                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntents2Exercise.class);
                intent.putExtra("First_Name", f);
                intent.putExtra("Last_Name", l);
                intent.putExtra("Gender", gender);
                intent.putExtra("Birthdate", birthdate);
                intent.putExtra("Phone_Number", phone);
                intent.putExtra("Email", email);
                intent.putExtra("Address", address);
                intent.putExtra("Department", dept);
                intent.putExtra("Program", program);
                intent.putExtra("Year", year);

                startActivity(intent);
            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FName.setText("");
                LName.setText("");

                for (RadioButton r : genders) {
                    if (r.isChecked()) {
                        r.setChecked(false);
                    }
                }

                Birthdate.setText("");
                PhoneNumber.setText("");
                Email.setText("");
                Address.setText("");
                Department.setText("");
                Program.setText("");


                for (RadioButton r : years) {
                    if (r.isChecked()) {
                        r.setChecked(false);
                    }
                }
            }
        });

    }
}