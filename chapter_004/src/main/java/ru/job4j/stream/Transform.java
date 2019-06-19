package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Transform {
    List<Integer> transofrmMatrixToList(Integer[][] arr) {
        return Arrays.stream(arr).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
