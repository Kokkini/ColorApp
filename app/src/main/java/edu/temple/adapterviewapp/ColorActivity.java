package edu.temple.adapterviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.drawable.ColorDrawable;

public class ColorActivity extends AppCompatActivity {
    Spinner spinner;
    ConstraintLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        spinner = findViewById(R.id.spinner);

        String colors[] = {"red", "green", "blue", "cyan", "magenta", "gray", "black", "lime", "aqua", "fuchsia", "yellow", "teal"};

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, colors);

        final ColorAdapter adapter = new ColorAdapter(this, colors);



        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ColorDrawable color = (ColorDrawable) view.getBackground();
                mainLayout.setBackgroundColor(color.getColor());
                view.setBackgroundColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
