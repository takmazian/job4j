package ru.job4j.loop;

public class Factorial {
    int calc(int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s *= i;
        }
        return s;
    }
}
