import com.sun.management.GcInfo;

public class Pots_of_gold {
    public static int findMaxCoins(int[] coin, int i, int j, int[][] lookup) {
        if (i==j) {
            return coin[i];
        }
        if (i + 1 == j) {
            return Integer.max(coin[i],coin[j]);
        }
        if (lookup[i][j] == 0) {
            int start = coin[i] + Integer.min(findMaxCoins(coin, i + 2, j, lookup), findMaxCoins(coin,i+1, j-1, lookup));
            int end = coin[j] + Integer.min(findMaxCoins(coin, i + 1, j - 1, lookup), findMaxCoins(coin, i, j - 2, lookup));

            lookup[i][j] = Integer.max(start, end);
        }
        return lookup[i][j];
    }

    public static void main(String[] args) {
        int[] coin = {4, 6, 2, 3};
        int[][] lookup = new int[coin.length][coin.length];

        System.out.println(findMaxCoins(coin, 0, coin.length - 1, lookup));
    }
}
