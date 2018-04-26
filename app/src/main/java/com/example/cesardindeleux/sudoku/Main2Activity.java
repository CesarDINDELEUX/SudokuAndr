package com.example.cesardindeleux.sudoku;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

        Bundle objetBundle = this.getIntent().getExtras();
        String phrase = objetBundle.getString("Level");

        // Construct the data source
        ArrayList<vgrile> vgrilesArray = new ArrayList<vgrile>();
        vgrilesArray = vgrile.createEntries(phrase);
        vgAdapter adapter = new vgAdapter(this, vgrilesArray);
        final ListView listView = (ListView) findViewById(R.id.LVvgrile);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Object o = listView.getItemAtPosition(position);
                Intent i = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(i);

            }
        });
    }


}
