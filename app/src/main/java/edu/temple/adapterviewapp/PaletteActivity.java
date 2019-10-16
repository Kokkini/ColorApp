package edu.temple.adapterviewapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;


public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ColorSelectedInterface {
    Spinner spinner;
    ConstraintLayout mainLayout;
    PaletteFragment paletteFragment;
    ColorFragment colorFragment;
    String noColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] colors = res.getStringArray(R.array.colors);
        String pickColor = res.getString(R.string.pickColor);
        noColor = colors[0].split(":")[1];
        getSupportActionBar().setTitle(res.getString(R.string.paletteActivity));


        paletteFragment = PaletteFragment.newInstance(colors);
        colorFragment = new ColorFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.PaletteLayout, paletteFragment).commit();

        fragmentManager.beginTransaction().add(R.id.CanvasLayout, colorFragment).commit();


        mainLayout = findViewById(R.id.mainLayout);

    }

    @Override
    public void colorSelected(String colorName) {
        if (! colorName.equals(noColor)) {
            colorFragment.messageReceived(colorName);
        }
    }
}
