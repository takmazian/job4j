package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows != 0 ? list.size() / rows + 1 : list.size() / rows;
        int[][] array = new int[rows][cells];
        int str = 0;
        int row = 0;
        for (Integer elem : list) {
            if (array[row].length != str) {
                array[row][str++] = elem;
            } else {
                str = 0;
                array[++row][str++] = elem;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        list.forEach(elem -> Arrays.stream(elem).forEach(result::add));
        return result;
    }


}