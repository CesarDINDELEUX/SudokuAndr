package com.example.cesardindeleux.sudoku;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by cesardindeleux on 25/04/2018.
 */


public class Draw extends View implements View.OnTouchListener {


    private final int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private final int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    private int  stepSize = screenWidth / 9;
    private int mouseX;
    private int mouseY;
    private int touchedNumber = 0;
    public Draw(Context context) {
        super(context);
        this.setOnTouchListener(this);
    }
    String chaine = "008203500009670408346050702430010059967005001000496203280034067703500904004107020";
    private String grilleAnswer = "000000000000000000000000000000000000000000000000000000000000000000000000000000000";
    String [] chaine2 = (chaine.split(""));
    @Override
    public void onDraw(Canvas canvas){
        Paint paintChiffre = new Paint(Color.RED);
        paintChiffre.setTextSize(90);

      Paint STRONGBLACK = new Paint(Color.BLACK);
      STRONGBLACK.setStrokeWidth(10);



        if (touchedNumber != 0)
            canvas.drawText(String.valueOf(touchedNumber), mouseX, mouseY, paintChiffre);


        for (int i = 0; i <= 9; i++) {

            if (i == 3 || i == 6 || i == 9)
            {
                canvas.drawLine(0, i * stepSize, screenWidth, i * stepSize, STRONGBLACK);
                canvas.drawLine(stepSize*i, stepSize*9, stepSize*i, 0, STRONGBLACK);
            }
            else{
                canvas.drawLine(0, i * stepSize, screenWidth, i * stepSize, new Paint(Color.BLACK));
                canvas.drawLine(stepSize*i, stepSize*9, stepSize*i, 0, new Paint(Color.BLACK));
            }

            canvas.drawLine(stepSize*i, stepSize*10, stepSize*i, stepSize*11, STRONGBLACK);

        }

        for (int i = 0; i < 81; i++) {
            int x = i / 9;
            int y = i % 9;
            if (chaine.charAt(i) != '0') {
                canvas.drawText(String.valueOf(chaine.charAt(i)),  (x * stepSize + (stepSize / 2))-27,  (y * stepSize + (stepSize / 2))+27, paintChiffre);
            }
            else if (grilleAnswer.charAt(i) != '0'){
                canvas.drawText(String.valueOf(grilleAnswer.charAt(i)),  (x * stepSize + (stepSize / 2))-27,  (y * stepSize + (stepSize / 2))+27, paintChiffre);
            }
        }

        canvas.drawLine(0, stepSize*10, screenWidth, stepSize*10, STRONGBLACK);
        canvas.drawLine(0, stepSize*11, screenWidth, stepSize*11, STRONGBLACK);

        for (int i = 0; i < 9; i++){
            canvas.drawText(String.valueOf(i+1), stepSize * i + 55,stepSize*11 - 55, paintChiffre );
         }



    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mouseX = (int) motionEvent.getX();
        mouseY = (int) motionEvent.getY();
        int selectedValue;
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                    touchedNumber = getSelectedNumber(mouseX, mouseY);
                    Log.e("Chiffre touché :", " "+touchedNumber);
                    break;
            case MotionEvent.ACTION_UP:
                int index = getIndex(mouseX, mouseY);
               // if (index != -1 && grille.charAt(index) == '0' && selectedValue != 0) {
               //     grilleAnswer = grilleAnswer.substring(0, index) + selectedValue + grilleAnswer.substring(index + 1);
               // }
               // selectedValue = 0;
                grilleAnswer = grilleAnswer.substring(0, index) + touchedNumber + grilleAnswer.substring(index + 1);
                touchedNumber = 0;
                break;
        }
        this.invalidate();
        return true;
    }
    private int getSelectedNumber(int x, int y) {
        if (y < 10 * stepSize + 1 || y > (10 + 1) * stepSize + 1)
            return 0;
        else
            return (x / stepSize) + 1;
    }

    private int getIndex(int x, int y) {
        if (y > screenWidth)
            return -1;
        else
            return ((x / stepSize)) * 9 + (y / stepSize);

    }
}
