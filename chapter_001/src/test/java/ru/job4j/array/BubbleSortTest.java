package ru.job4j.array;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void test1() {
        int[] expect = (new BubbleSort()).sort(new int[]{5, 1, 2, 7, 3});
        int[] result = new int[]{1, 2, 3, 5, 7};
        assertThat(result, is(expect));
    }

    @Test
    public void test2() {
        int[] expect = (new BubbleSort()).sort(new int[]{5, 10, 3, 15});
        int[] result = new int[]{3, 5, 10, 15};
        assertThat(result, is(expect));
    }
}
