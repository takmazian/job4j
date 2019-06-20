package ru.job4j.tictactoe;

import java.util.function.Function;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isWinner(Predicate<Figure3T> function){
        return this.fillBy(function, 0, 0, 1, 0)
                || this.fillBy(function, 0, 0, 0, 1)
                || this.fillBy(function, 0, 0, 1, 1)
                || this.fillBy(function, 1, 0, 0, 1)
                || this.fillBy(function, this.table.length - 1, 0, 0, 1)
                || this.fillBy(function, 0, 1, 1, 0)
                || this.fillBy(function, 0, this.table.length - 1, 1, 0)
                || this.fillBy(function, this.table.length - 1, 0, -1, 1);
    }


    public boolean isWinnerX() {
        return isWinner(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isWinner(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(!table[i][j].hasMarkO() && !table[i][j].hasMarkX()){
                    result = true;
                    break;
                }
            }
            if(result){
                break;
            }
        }
        return result;
    }
}
