package ru.job4j.tracker;

public interface Input {
    String ask(String request);

    int ask(String question, Integer[] range);

}
