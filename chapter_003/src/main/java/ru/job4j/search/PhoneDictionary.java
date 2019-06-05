package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            boolean contains = false;
            if (person.getAddress().contains(key)) {
                contains = true;
            } else if (person.getName().contains(key)) {
                contains = true;
            } else if (person.getPhone().contains(key)) {
                contains = true;
            } else if (person.getSurname().contains(key)) {
                contains = true;
            }
            if (contains) {
                result.add(person);
            }
        }
        return result;
    }
}