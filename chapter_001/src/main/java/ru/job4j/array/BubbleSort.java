package ru.job4j.array;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    public int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = array[i];
                if (a < array[j]) {
                    array[i] = array[j];
                    array[j] = a;
                }
            }
        }
        return array;
    }
}
