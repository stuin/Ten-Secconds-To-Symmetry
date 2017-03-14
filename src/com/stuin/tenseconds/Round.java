package com.stuin.tenseconds;

import android.content.Context;
import com.stuin.tenseconds.Views.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Stuart on 3/14/2017.
 */
public class Round {
    public static int size;
    public static int scale;
    public static List<Cell> cells;
    static int colors;

    static void generate(Context context) {
        cells = new ArrayList<>();
        Random rand = new Random();

        for(int y = 0; y < size; y++) for(int x = 0; x < size; x++) {
            cells.add(new Cell(context, rand.nextInt(colors), x, y));
        }

        cells.get(rand.nextInt(cells.size()));
    }
}
