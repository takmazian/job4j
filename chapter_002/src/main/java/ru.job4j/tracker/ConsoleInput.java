package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String request) {
        System.out.print(request);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, Integer[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of  menu range.");
        } else {
            return key;
        }
    }

}