package com.example.cesardindeleux.sudoku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class vgAdapter extends ArrayAdapter<vgrile> {
    public vgAdapter(Context context, ArrayList<vgrile> vgriles) {
        super(context, 0, vgriles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        vgrile vg = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_vgrile, parent, false);
        }
        // Lookup view for data population
        TextView vgDone = (TextView) convertView.findViewById(R.id.vgDone);
        TextView vgLevel = (TextView) convertView.findViewById(R.id.vgLevel);
        TextView vgNum = (TextView) convertView.findViewById(R.id.vgNum);
        // Populate the data into the template view using the data object
        vgNum.setText(vg.getNum());
        vgLevel.setText(vg.getLevel());
        vgDone.setText(vg.getDone());
        // Return the completed view to render on screen
        return convertView;
    }
}
