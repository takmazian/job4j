package ru.job4j.array;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    public boolean mono(boolean[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1] ^ data[i]) {
                return false;
            }
        }
        return true;
    }
}
