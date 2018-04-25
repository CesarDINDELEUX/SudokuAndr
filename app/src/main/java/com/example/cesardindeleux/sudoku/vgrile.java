package com.example.cesardindeleux.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cesardindeleux on 25/04/2018.
 */

public class vgrile {
    private int level;
    private int num;
    private int done;





    public static ArrayList<vgrile> createEntries(){
        ArrayList<vgrile> listeVgrile = new ArrayList<vgrile>();
        for (int i = 1; i < 101; i++) {

            vgrile grile = new vgrile();
            grile.num = i;
            Random randomlevel = new Random();
            Random randomdone = new Random();
            grile.level =  randomlevel.nextInt((2+1) - 1) + 1;
            grile.done = randomdone.nextInt((100+1) - 0) + 0;
            listeVgrile.add(grile);
        }
        return listeVgrile;

    }

    public int getLevel() {
        return level;
    }

    public int getNum() {
        return num;
    }

    public int getDone() {
        return done;
    }
}


