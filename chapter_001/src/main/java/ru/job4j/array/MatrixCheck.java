package ru.job4j.array;

/**
 * @author Andrey Takmazyan (takmazian@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        int l = data.length;
        for (int i = 1; i < l; i++) {
            if ((data[i][i] ^ data[i - 1][i - 1])
                    || (data[i][l - i - 1] ^ data[i - 1][l - i])) {
                return false;
            }
        }
        return true;
    }
}
