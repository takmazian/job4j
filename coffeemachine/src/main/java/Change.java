import java.util.Arrays;

public class Change {
    int[] changes(int value, int price) {
        value-=price;
        int[] maxCoins = new int[value / 10 + 1];
        int[] COINS = new int[]{10,5,2,1};
        int iter = 0;
        for(int coin : COINS) {
            while (value - coin >= 0) {
                    maxCoins[iter++] = coin;
                    value-=coin;
            }
        }
        return Arrays.copyOf(maxCoins, iter);
    }
}
