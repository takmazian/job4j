package ru.job4j.comparator;

import java.util.Comparator;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int maxLength = left.length() > right.length() ? left.length() : right.length();
        for (int i = 0; i < maxLength; i++) {
            int leftSymb = 'Z' + 1;
            int rightSymb = 'Z' + 1;
            try {
                leftSymb = left.charAt(i);
            } catch (Exception e) {
            }
            try {
                rightSymb = right.charAt(i);
            } catch (Exception e) {
            }
            if (leftSymb != rightSymb) {
                result = Integer.compare(leftSymb, rightSymb);
                break;
            }
        }
        return result;
    }
}