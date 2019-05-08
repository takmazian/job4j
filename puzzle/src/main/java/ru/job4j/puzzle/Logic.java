package ru.job4j.puzzle;

import ru.job4j.puzzle.firuges.Cell;
import ru.job4j.puzzle.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final int size;
    private final Figure[] figures;
    private int index = 0;

    public Logic(int size) {
        this.size = size;
        this.figures = new Figure[size * size];
    }

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (this.isFree(steps)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public boolean isFree(Cell... cells) {
        boolean result = cells.length > 0;
        for (Cell cell : cells) {
            if (this.findBy(cell) != -1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public boolean isWin() {
        int[][] table = this.convert();
        boolean result = false;
        for (int i = 0; i < table.length; i++) {
            int sumInLine = 0;
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 1) {
                    sumInLine++;
                    boolean allInColumn = true;
                    for (int z = 1; z < table.length; z++) {
                        if (table[z][j] == 0) {
                            allInColumn = false;
                        }
                    }
                    int mid = table.length / 2;
                    if (j == mid && !allInColumn && table[mid][mid] == 0) {
                        int sumInCross = 0;
                        boolean cross = true;
                        for (int l = i + 1; l < table.length; l++) {
                            if (table[l][mid] == 1) {
                                sumInCross++;
                            }
                        }
                        if (sumInCross == table.length - 1) {
                            return true;
                        }
                    }
                    if (allInColumn) {
                        return true;
                    }
                }
            }
            if (sumInLine == table.length) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int[][] convert() {
        int[][] table = new int[this.size][this.size];
        for (int row = 0; row != table.length; row++) {
            for (int cell = 0; cell != table.length; cell++) {
                int position = this.findBy(new Cell(row, cell));
                if (position != -1 && this.figures[position].movable()) {
                    table[row][cell] = 1;
                }
            }
        }
        return table;
    }
}
