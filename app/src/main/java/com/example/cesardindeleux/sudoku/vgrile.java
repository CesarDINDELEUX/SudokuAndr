package com.example.cesardindeleux.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by cesardindeleux on 25/04/2018.
 */

public class vgrile {
    int level;
    int num;
    int done;





    public static List<vgrile> createEntries(){
    List<vgrile> listeVgrile = new ArrayList<vgrile>();
        for (int i = 1; i < 101; i++) {

            vgrile grile = new vgrile();
            grile.num = 1;
            Random randomlevel = new Random();
            grile.level =  randomlevel.nextInt((2+1) - 1) + 1;
            grile.done = 0;
            listeVgrile.add(grile);
        }
    return listeVgrile;

    }
}


