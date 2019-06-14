package ru.job4j.function;

import java.util.List;
import java.util.function.Function;

public interface Diapason {
    List<Double> diapason(int start, int end, Function<Double, Double> func);
}
