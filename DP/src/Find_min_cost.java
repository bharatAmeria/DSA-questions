public class Find_min_cost {
    public static int findMinCost(int[][] cost, int m, int n) {
        if (n==0 || m==0) {
            return Integer.MAX_VALUE;
        }
        if (m==1 && n==1) {
            return cost[0][0];
        }
        return  Integer.max(findMinCost(cost,m-1,n),findMinCost(cost,m,n-1)) + cost[m-1][n-1];
    }
    public static int findMinCost(int[][] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        return findMinCost(cost,cost.length,cost[0].length);
    }

    public static void main(String[] args) {
        int[][] cost =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };
        System.out.println(findMinCost(cost));
    }
}
