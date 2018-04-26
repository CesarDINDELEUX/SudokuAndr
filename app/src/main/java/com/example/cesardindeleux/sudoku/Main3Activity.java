package com.example.cesardindeleux.sudoku;

import android.os.Bundle;
import android.app.Activity;

public class Main3Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Draw(this));
    }





}
