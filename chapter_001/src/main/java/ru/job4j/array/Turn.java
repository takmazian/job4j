package ru.job4j.array;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    public int[] back(int[] array) {
        for (int i = 0; i <= array.length / 2 - 1; i++) {
            int a = array[i];
            int j = array.length - i - 1;
            array[i] = array[j];
            array[j] = a;
        }
        return array;
    }
}
