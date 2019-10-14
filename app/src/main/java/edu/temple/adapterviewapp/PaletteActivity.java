package edu.temple.adapterviewapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


public class PaletteActivity extends AppCompatActivity {
    Spinner spinner;
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] colors = res.getStringArray(R.array.colors);
        String pickColor = res.getString(R.string.pickColor);
        final String colorMessage = res.getString(R.string.colorMessage);
        final String noColor = colors[0].split(":")[1];
        getSupportActionBar().setTitle(res.getString(R.string.paletteActivity));


        mainLayout = findViewById(R.id.mainLayout);
        spinner = findViewById(R.id.spinner);


        final ColorAdapter adapter = new ColorAdapter(this, colors, pickColor);



        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                ColorDrawable color = (ColorDrawable) view.getBackground();
                view.setBackgroundColor(Color.WHITE);
                if (! ((String) adapter.getItem(i)).split(":")[1].equals(noColor)){
//                    canvasLayout.setBackgroundColor(color.getColor());
                    Intent launchActivity = new Intent(PaletteActivity.this, CanvasActivity.class);
                    launchActivity.putExtra(colorMessage, ((String) adapter.getItem(i)).split(":")[1]);
                    startActivity(launchActivity);
                }
//                mainLayout.setBackgroundColor(color.getColor());
//                Intent launchActivity = new Intent(PaletteActivity.this, CanvasActivity.class);
//                startActivity(launchActivity);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
