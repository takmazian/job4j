package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 * чо-то сложно как-то получилось... может не то?
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int uniqueLength = array.length;
        for (int i = 0; i < uniqueLength; i++) {
            for (int j = i + 1; j < uniqueLength; j++) {
                while (array[i].equals(array[j])) { // переставить дубликат в конец
                    uniqueLength--;
                    if(j < uniqueLength) {
                        String a = array[j];
                        array[j] = array[uniqueLength];
                        array[uniqueLength] = a;
                    } else {
                        break;
                    }
                }
            }
        }
        return Arrays.copyOf(array, uniqueLength);
    }
}
