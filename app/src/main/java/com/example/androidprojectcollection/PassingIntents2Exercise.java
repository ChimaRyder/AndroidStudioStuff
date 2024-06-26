package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntents2Exercise extends AppCompatActivity {

    private TextView Name;
    private TextView Gender;
    private TextView Birthdate;
    private TextView PhoneNumber;
    private TextView Email;
    private TextView Address;
    private TextView TwitterHandle;
    private TextView Department;
    private TextView Program;
    private TextView Year;
    private Button Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents2_exercise);

        Intent intent = getIntent();

        Name = (TextView) findViewById(R.id.profileName);
        Gender = (TextView) findViewById(R.id.profileGender);
        Birthdate = (TextView) findViewById(R.id.profileBirthdate);
        Email = (TextView) findViewById(R.id.profileEmail);
        PhoneNumber = (TextView) findViewById(R.id.profilePhone);
        Address = (TextView) findViewById(R.id.profileAddress);
        TwitterHandle = (TextView) findViewById(R.id.profileTwitterHandle);
        Department = (TextView) findViewById(R.id.profileDepartment);
        Program = (TextView) findViewById(R.id.profileProgram);
        Year = (TextView) findViewById(R.id.profileYear);
        Return = (Button) findViewById(R.id.btnReturnProfile);


        Name.setText(intent.getStringExtra("First_Name") + " " + intent.getStringExtra("Last_Name"));
        Gender.setText(intent.getStringExtra("Gender"));
        Birthdate.setText(intent.getStringExtra("Birthdate"));
        Email.setText(intent.getStringExtra("Email"));
        PhoneNumber.setText(intent.getStringExtra("Phone_Number"));
        Address.setText(intent.getStringExtra("Address"));
        TwitterHandle.setText(intent.getStringExtra("Twitter_Handle"));
        Department.setText(intent.getStringExtra("Department"));
        Program.setText(intent.getStringExtra("Program"));
        Year.setText(intent.getStringExtra("Year"));

        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}