package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    private List<Item> items = new ArrayList<>();

    /**
     * Добавление элемента в трекер.
     *
     * @return вовзрат ссылки на элемент
     */
    public Item add(Item item) {

        items.add(item);

        item.setId(generateId());
        return item;
    }

    /**
     * Замена элемента в трекере по id.
     *
     * @param id   ID элемента, которого необходимо заменить.
     * @param item Элемент, которым заменяем
     * @return Возврат выполнилась операция или нет
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.set(i, item);
                item.setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Удаление элемента в трекере по id.
     *
     * @param id ID элемента, которого удаляем
     * @return Возврат выполнилась операция или нет
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Возврат текущего массива элементов без null
     *
     * @return Возврат массива элементов
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Поиск элемента по имени
     *
     * @param key имя с которым будут сравниваться имена элементов
     * @return Возврат массива элементов
     */
    public List<Item> findByName(String key) {
        List<Item> buf = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                buf.add(item);
            }
        }
        return buf;
    }

    /**
     * Поиск элемента по id
     *
     * @param id ID с которым будут сравниваться id элементов
     * @return Возврат элемента или null
     */
    public Item findById(String id) {
        Item item = null;
        for (Item item1 : items) {
            if (item1.getId().equals(id)) {
                item = item1;
                break;
            }
        }
        return item;
    }

    /**
     * Генерация ID
     *
     * @return Возврат сгенерированый ID
     */
    public String generateId() {
        String result = "";
        Random random = new Random();
        result += System.currentTimeMillis() * random.nextInt(100);
        return result;
    }
}