package ru.job4j.array;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void t2() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        String[] result = new ArrayDuplicate().remove(input);
        assertThat(result, is(expect));
    }

    @Test
    public void t1() {
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Супер", "Мир"};
        String[] expect = {"Привет", "Мир", "Супер"};
        String[] result = new ArrayDuplicate().remove(input);
        assertThat(result, is(expect));
    }

    @Test
    public void t3() {
        String[] input = {"Привет", "Привет", "Мир"};
        String[] expect = {"Привет", "Мир"};
        String[] result = new ArrayDuplicate().remove(input);
        assertThat(result, is(expect));
    }


    @Test
    public void t4() {
        String[] input = {"Привет", "Привет", "Привет", "Привет", "Привет"};
        String[] expect = {"Привет"};
        String[] result = new ArrayDuplicate().remove(input);
        assertThat(result, is(expect));
    }
}
