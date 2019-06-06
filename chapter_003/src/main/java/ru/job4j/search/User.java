package ru.job4j.search;

public class User implements Comparable<User> {
    private Integer id;
    private String name;
    private String city;
    private Integer age;

    public int getId() {
        return this.id;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User o) {
        return age.compareTo(o.age);
    }

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
