package ru.job4j.array;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     *
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        char[] prefixArray = prefix.toCharArray();
        if (data.length < prefixArray.length) {
            return false;
        }
        for (int i = 0; i < prefixArray.length; i++) {
            if (data[i] != prefixArray[i]) {
                return false;
            }
        }
        return true;
    }
}

