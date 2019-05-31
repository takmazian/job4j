package ru.job4j.chess.figures;

import ru.job4j.chess.exceptions.ImpossibleMoveException;

import java.util.Arrays;
import java.util.List;

public interface Figure {
    Cell[] CELLS = Cell.values();

    Cell position();

    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    Figure copy(Cell dest);

    default boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int diffX = Math.abs(source.x - dest.x);
        int diffY = Math.abs(source.y - dest.y);
        if (diffX == diffY) {
            result = true;
        }
        return result;
    }

    default boolean isCross(Cell source, Cell dest) {
        boolean result = false;
        if (((source.x - dest.x == 0) && (source.y - dest.y != 0)) || ((source.x - dest.x != 0) && (source.y - dest.y == 0))) {
            result = true;
        }
        return result;
    }

    default Cell[] findWay(Cell source, Cell dest) {
        Cell[] steps;
        int diffX = Math.abs(source.x - dest.x);
        int diffY = Math.abs(source.y - dest.y);
        int operator1 = Integer.compare(0, source.x - dest.x);
        int operator2 = Integer.compare(0, source.y - dest.y);
        if (diffX != 0) {
            steps = new Cell[diffX];
        } else {
            steps = new Cell[diffY];
        }
        for (int i = 0; i < steps.length; i++) {
            steps[i] = CELLS[source.ordinal() + (i + 1) * 8 * operator1 + (i + 1) * operator2];
        }
        return steps;
    }

    default boolean isKing(Cell source, Cell dest) {
        boolean result = false;
        if ((Math.abs(source.x - dest.x) == 1 && Math.abs(source.y - dest.y) == 0)
                || (Math.abs(source.x - dest.x) == 0 && Math.abs(source.y - dest.y) == 1)
                || (Math.abs(source.x - dest.x) == 1 && Math.abs(source.y - dest.y) == 1)) {
            result = true;
        }
        return result;
    }

    default boolean isKnight(Cell source, Cell dest) {
        boolean result = false;
        if ((Math.abs(dest.x - source.x) == 1 && Math.abs(dest.y - source.y) == 2) || (Math.abs(dest.y - source.y) == 1 && Math.abs(dest.x - source.x) == 2)) {
            result = true;
        }
        return result;
    }
}
