package com.example.cesardindeleux.sudoku;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // Construct the data source
        ArrayList<vgrile> vgrilesArray = new ArrayList<vgrile>();
        vgrilesArray = vgrile.createEntries();
        vgAdapter adapter = new vgAdapter(this, vgrilesArray);
        ListView listView = (ListView) findViewById(R.id.LVvgrile);
        listView.setAdapter(adapter);
    }
}
