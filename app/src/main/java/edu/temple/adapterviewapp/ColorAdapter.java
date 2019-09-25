package edu.temple.adapterviewapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    Context context;
    String colors[];
    public ColorAdapter(Context context, String colors[]){
        this.context = context;
        this.colors = colors;
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
        String color = colors[i];

        textView.setText(color);

        textView.setBackgroundColor(Color.parseColor(color));

        textView.setTextSize(22);

        textView.setPadding(15,5, 0, 5);
        return textView;
    }
}
