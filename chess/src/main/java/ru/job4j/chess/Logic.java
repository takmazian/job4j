package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.*;
import ru.job4j.chess.figures.white.*;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;
    private boolean isWhiteTurn = true;
    private boolean isPlay = false;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }


    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, FigureNotFoundException, OccupiedWayException {
        int numFigure = findBy(source);
        if (numFigure == -1) {
            throw new FigureNotFoundException("Not found");
        }

        Cell[] cells = figures[numFigure].way(source, dest);
        if (occupiedWay(cells)) {
            throw new OccupiedWayException("No way");
        }
        this.figures[numFigure] = this.figures[numFigure].copy(dest);
        return true;
    }

    public boolean occupiedWay(Cell[] cells) {
        boolean result = false;
        for (Cell cell : cells) {
            if (findBy(cell) != -1) {
                result = true;
            }
        }
        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
        isWhiteTurn = true;
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
}
