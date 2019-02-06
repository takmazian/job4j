package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 * чо-то сложно как-то получилось... может не то?
 */
public class ArrayDuplicate {
    static int comlpexity = 0;
    public String[] remove1(String[] array) {
        int uniqueLength = array.length;
        for (int i = 0; i < uniqueLength; i++) {
            for (int j = i + 1; j < uniqueLength; j++) {
                comlpexity++;
                while (array[i].equals(array[j])) { // переставить дубликат в конец
                    uniqueLength--;
                    comlpexity++;
                    if(j < uniqueLength) {
                        array[j] = array[uniqueLength];
                        comlpexity++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(comlpexity);
        return Arrays.copyOf(array, uniqueLength);
    }
    public String[] remove(String[] array) {
        int uniqueLength = array.length;
        for (int i = 0; i < uniqueLength; i++) {
            for (int j = i + 1; j < uniqueLength; j++) {
                comlpexity++;
                if (array[i].equals(array[j])) { // переставить дубликат в конец
                    uniqueLength--;
                    array[j] = array[uniqueLength];
                    comlpexity++;
                    j--;
                }
            }
        }
        System.out.println(comlpexity);
        return Arrays.copyOf(array, uniqueLength);
    }
}
