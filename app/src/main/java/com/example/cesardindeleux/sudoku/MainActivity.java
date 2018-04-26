package com.example.cesardindeleux.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener  {
    Activity lecontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn1){
            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            Bundle lol = new Bundle();
            lol.putString("Level","1");
            i.putExtras(lol);
            startActivity(i);
           // this.startActivityForResult(i, 1);
        }
        else if (view.getId()==R.id.btn2){
            Intent i = new Intent(MainActivity.this, Main2Activity.class);
            Bundle lol = new Bundle();
            lol.putString("Level","2");
            i.putExtras(lol);
            startActivity(i);
        }
    }

}

