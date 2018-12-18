package ru.job4j.max;

public class Max {

    public int max(int first, int second) {
            return second < first ? first : second;
    }

    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
