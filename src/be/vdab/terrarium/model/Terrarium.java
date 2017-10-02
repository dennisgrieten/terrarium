package be.vdab.terrarium.model;

import java.util.ArrayList;
import java.util.List;

public enum Terrarium {
    INSTANCE;
    private final int DIMENSIE = 6;
    private Cell[][] matrix;

    Terrarium() {
        matrix = new Cell[DIMENSIE][DIMENSIE];
    }
}
