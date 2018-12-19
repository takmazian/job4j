package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        boolean[][] input = new boolean[][] {
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = new MatrixCheck().mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        boolean[][] input = new boolean[][] {
                {true, false, true},
                {false, false, false},
                {true, false, true}
        };
        boolean result = new MatrixCheck().mono(input);
        assertThat(result, is(false));
    }
    @Test
    public void t1() {
        boolean[][] input = new boolean[][] {
                {true, false},
                {false, true},
        };
        boolean result = new MatrixCheck().mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void t2() {
        boolean[][] input = new boolean[][] {
                {true, false},
                {true, true}
        };
        boolean result = new MatrixCheck().mono(input);
        assertThat(result, is(false));
    }
}