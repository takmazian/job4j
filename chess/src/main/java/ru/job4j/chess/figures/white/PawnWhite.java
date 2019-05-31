package ru.job4j.chess.figures.white;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if ((source.y == dest.y - 1 && source.x == dest.x) || (source.y == 1 && dest.y == source.y + 2 && source.x == dest.x)) {
            return findWay(source, dest);
        } else {
            throw new ImpossibleMoveException("Impossible Move");
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
