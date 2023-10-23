import java.util.HashMap;
import java.util.Map;

public class optimal_knapsack {

    public static int knapsack(int[] val, int[] wt, int n, int w, Map<String, Integer> lookup) {
        if (w < 0) {
            return Integer.MIN_VALUE;
        }
        if (n < 0 || w == 0) {
            return 0;
        }

        String key = n + "|" + w;
        if (!lookup.containsKey(key)) {
            int include = val[n] + knapsack(val, wt, n-1,w-wt[n],lookup);
            int exclude = knapsack(val, wt, n-1, w, lookup);
            lookup.put(key, Integer.max(include, exclude));
        }
        return lookup.get(key);
    }
    //    using top-down approach
    public static int kanpsack(int[] v, int[] weight, int W) {
        int [][] t = new int[v.length + 1][W+1];

        for (int i = 0; i <= v.length ; i++) {
            for (int j = 0; j <= W ; j++) {
                if (weight[i-1] > j) {
                    t[i][j] = t[i-1][j];
                }else {
                    t[i][j] = Integer.max(t[i-1][j], t[i-1][j-weight[i-1]] + v[i-1]);
                }
            }
        }
        return t[v.length][W];
    }

    public static void main(String[] args) {
        int[] val = {20, 5, 10, 40, 15, 25};
        int[] wt = { 1, 2, 3, 8, 7, 4};
        int w = 10;

//        # top-down
        int[] v = {20, 5, 10, 40, 15, 25};
        int[] weight = { 1, 2, 3, 8, 7, 4};
        int W = 10;
        System.out.println("Knapsack value is " + kanpsack(v, weight,W));

        Map<String,Integer> lookup = new HashMap<>();
        System.out.println("Knapsack value is " +
                knapsack(val, wt, val.length - 1, w, lookup));
    }


}
