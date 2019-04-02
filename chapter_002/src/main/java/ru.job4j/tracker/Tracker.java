package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int count = 0;

    /**
     * Добавление элемента в трекер.
     *
     * @return вовзрат ссылки на элемент
     */
    public Item add(Item item) {

        items[count] = item;

        item.setId(generateId());
        count++;
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
        for (int i = 0; i < count; i++)
            if (items[i].getId().equals(id)) {
                items[i] = item;
                result = true;
                break;
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
        for (int i = 0; i < count; i++)
            if (items[i].getId().equals(id)) {
                System.arraycopy(items, i + 1, items, i, count - i - 1);
                count--;
                result = true;
                break;
            }
        return result;
    }

    /**
     * Возврат текущего массива элементов без null
     *
     * @return Возврат массива элементов
     */
    public Item[] findAll() {
        return Arrays.copyOf(items,count);
    }

    /**
     * Поиск элемента по имени
     *
     * @param key имя с которым будут сравниваться имена элементов
     * @return Возврат массива элементов
     */
    public Item[] findByName(String key) {
        Item[] buf = new Item[count];
        int countArray = 0;
        for (int i = 0; i < count; i++)
            if (items[i].getName().equals(key)){
               buf[countArray++] = items[i];
            }
        return Arrays.copyOf(buf,countArray);
    }

    /**
     * Поиск элемента по id
     *
     * @param id ID с которым будут сравниваться id элементов
     * @return Возврат элемента или null
     */
    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < count; i++)
            if (items[i].getId().equals(id))
                item = items[i];
        return item;
    }

    /**
     * Генерация ID
     *
     *  @return Возврат сгенерированый ID
     */
    public String generateId() {
        String result = "";
        Random random = new Random();
        result += System.currentTimeMillis() * random.nextInt(100);
        return result;
    }
}
