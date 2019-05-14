package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    public String ask(String request) {
        System.out.print(request);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}