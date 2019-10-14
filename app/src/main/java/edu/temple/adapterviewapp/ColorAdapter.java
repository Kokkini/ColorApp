package edu.temple.adapterviewapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    Context context;
    String colors[];
    String pickColor;
    String noColor;
    Resources res;
    String defaultColor;

    public ColorAdapter(Context context, String colors[], String pickColor){
        this.context = context;
        this.colors = colors;
        this.pickColor = pickColor;
        this.noColor = colors[0].split(":")[1];
        this.defaultColor = context.getResources().getString(R.string.defaultColor);
    }


    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return colors[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        if(view != null && view instanceof TextView){
            textView = (TextView) view;
        }
        else {
            textView = new TextView(context);
        }


        String[] color = colors[i].split(":");



        if(color[1].equals(noColor)){
            color[1] = defaultColor;
            textView.setText(this.pickColor);
        }
        else {
            textView.setText(color[0]);
        }
        textView.setBackgroundColor(Color.parseColor(color[1]));

        textView.setTextSize(22);

        textView.setPadding(15,5, 0, 5);
        return textView;
    }
}
