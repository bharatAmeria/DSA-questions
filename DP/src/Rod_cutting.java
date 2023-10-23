public class Rod_cutting {
    public static int rodCutting(int[] price, int n) {
        if (n == 0) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int cost = price[i - 1] + rodCutting(price, n - i);

            if (cost > maxValue) {
                maxValue = cost;
            }
        }
        return maxValue;

    }
    public static int rodCut(int[] price, int n) {
        int[] t = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                t[i] = Integer.max(t[i], price[j-1] + t[i - j]);
            }
        }
        return t[n];
    }

    public static void main(String[] args) {
        int price[] = {1,5,8,9,10,17,17,20};

        int n = 8;
        System.out.println(rodCutting(price, n));
        System.out.println(rodCut(price, n));
    }
}