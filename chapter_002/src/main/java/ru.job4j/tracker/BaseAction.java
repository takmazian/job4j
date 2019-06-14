package ru.job4j.tracker;

import java.util.function.Consumer;

public abstract class BaseAction implements UserAction {
    private int key;
    private String name;
    Consumer<String> output;

    protected BaseAction(final int key, final String name, Consumer<String> output) {
        this.key = key;
        this.name = name;
        this.output = output;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}