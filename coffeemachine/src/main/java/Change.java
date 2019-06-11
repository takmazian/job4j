import java.util.Arrays;

public class Change {
    int[] changes(int value, int price) {
        int[] maxCoins = new int[(value - price) / 10 + 1];
        int remain = value - price;
        int iter = 0;
        while (remain > 0) {
            if (remain >= 10) {
                maxCoins[iter++] = 10;
                remain -= 10;
            } else if (remain >= 5) {
                maxCoins[iter++] = 5;
                remain -= 5;
            } else if (remain >= 2) {
                maxCoins[iter++] = 2;
                remain -= 2;
            } else {
                maxCoins[iter++] = 1;
                remain -= 1;
            }
        }
        return Arrays.copyOf(maxCoins, iter);
    }
}
