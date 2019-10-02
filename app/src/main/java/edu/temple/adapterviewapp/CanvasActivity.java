package edu.temple.adapterviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {
    ConstraintLayout canvasLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        canvasLayout = findViewById(R.id.canvas);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String color = intent.getStringExtra("COLOR");
        canvasLayout.setBackgroundColor(Color.parseColor(color));

//
//        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(message);
    }
}
