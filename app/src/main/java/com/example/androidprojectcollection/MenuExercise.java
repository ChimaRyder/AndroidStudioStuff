package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MenuExercise extends AppCompatActivity {

    private Button Changer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        Changer = (Button) findViewById(R.id.btnChanger);
        Changer.setClickable(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Random r = new Random();

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(android.R.color.holo_green_dark);
        colors.add(android.R.color.holo_blue_dark);
        colors.add(android.R.color.holo_orange_dark);
        colors.add(android.R.color.holo_red_dark);

        ArrayList<Integer> sizes = new ArrayList<>();
        sizes.add(100);
        sizes.add(200);
        sizes.add(400);

        ArrayList<Float> fontsizes = new ArrayList<>();
        fontsizes.add(14.00f);
        fontsizes.add(24.00f);
        fontsizes.add(28.00f);

        if (id == R.id.miColor) {
            Changer.setBackgroundColor(getColor(colors.get(r.nextInt(colors.size()))));
            Toast.makeText(this, "Object's color has been changed.", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.miSize) {
            int size = sizes.get(r.nextInt(sizes.size()));
            final float scale = MenuExercise.this.getResources().getDisplayMetrics().density;
            int pixels = (int) (size * scale + 0.5f);
            Changer.setHeight(pixels);
            Changer.setWidth(pixels);
            Toast.makeText(this, "Object's size has been changed.", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.miText){
            AlertDialog.Builder b = new AlertDialog.Builder(MenuExercise.this);
            b.setTitle("Set Text");
            final EditText input = new EditText(MenuExercise.this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            b.setView(input);

            b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Changer.setText(input.getText().toString());
                    Toast.makeText(MenuExercise.this, "Text has been changed to: " + input.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });

            b.show();

        }

        else if (id == R.id.miFontColor) {
            Changer.setTextColor(getColor(colors.get(r.nextInt(colors.size()))));
            Toast.makeText(this, "Text Color has been changed.", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.miFontSize) {
            Changer.setTextSize(fontsizes.get(r.nextInt(fontsizes.size())));
            Toast.makeText(this, "Text Size has been changed.", Toast.LENGTH_SHORT).show();
        }

        else if (item.getItemId() == R.id.miReset) {
            Changer.setBackgroundColor(getColor(android.R.color.black));
            int size = 200;
            final float scale = MenuExercise.this.getResources().getDisplayMetrics().density;
            int pixels = (int) (size * scale + 0.5f);
            Changer.setHeight(pixels);
            Changer.setWidth(pixels);
            Changer.setText("GAME");
            Changer.setTextSize(20.00f);
            Changer.setTextColor(getColor(android.R.color.white));
            Toast.makeText(this, "Object has been reset.", Toast.LENGTH_SHORT).show();
        }



        else if (item.getItemId() == R.id.miExit) {
            finish();
        }

        return true;
    }
}