package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int minLength = left.length() > right.length() ? right.length() : left.length();
        int i;
        for (i = 0; i < minLength; i++) {
            int leftSymb = left.charAt(i);
            int rightSymb = right.charAt(i);
            if (leftSymb != rightSymb) {
                result = Integer.compare(leftSymb, rightSymb);
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length()) == 1 ? 1 : -1;
        }
        return result;
    }
}