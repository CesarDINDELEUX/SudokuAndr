package com.example.cesardindeleux.sudoku;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class vgAdapter extends ArrayAdapter<vgrile> {


    // View lookup cache
    private static class ViewHolder {
        TextView level;
        TextView num;
        TextView done;
    }

    public vgAdapter(Context context, ArrayList<vgrile> vgriles) {
        super(context, 0, vgriles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        vgrile vg = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_vgrile, parent, false);
            viewHolder.level = (TextView) convertView.findViewById(R.id.vgLevel);
            viewHolder.num = (TextView) convertView.findViewById(R.id.vgNum);
            viewHolder.done = (TextView) convertView.findViewById(R.id.vgDone);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.level.setText("Level : " +vg.getLevel());
        viewHolder.num.setText("Numero de grille : "+vg.getNum());
        viewHolder.done.setText("Reussite : "+vg.getDone() + "%");
         if ((int)vg.getDone() < 40){
             viewHolder.done.setTextColor(Color.RED);
         }
         else  {
             viewHolder.done.setTextColor(Color.GREEN);
         }
        // Return the completed view to render on screen
        return convertView;
    }
}
