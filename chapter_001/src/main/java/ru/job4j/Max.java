package ru.job4j;

public class Max {

    public int max (int first, int second) {
            return second < first ? first : second;
    }

    public int max(int first, int second, int third) {
        int temp = max(first,second);
        return max(temp,third);
    }
}
