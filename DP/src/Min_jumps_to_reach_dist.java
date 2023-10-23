public class Min_jumps_to_reach_dist {
    public static void main(String[] args) {
        int[] X = {1, 3, 6, 1, 0, 9};
        System.out.println(findMinJumps(X));
    }
    public static int minJumps(int[] X, int n, int i, int[] lookup) {
        if (i == n-1 ) {
            return 0;
        }
        if (i >= n || X[i] == 0) {
            return Integer.MAX_VALUE;
        }

        if (lookup[i] != 0) {
            return lookup[i];
        }

        int min_jumps = Integer.MAX_VALUE;
        for (int j = i+1; j < i+X[i]; j++) {
            int cost = minJumps(X,j,n,lookup);
            if (cost != Integer.MAX_VALUE) {
                min_jumps = Math.min(min_jumps, cost+1);
            }
        }
        return (lookup[i] = min_jumps);
    }
    public static int findMinJumps(int[] X) {
        if (X == null || X.length == 0) {
            return 0;
        }
        int[] lookup = new int[X.length];
        return minJumps(X,0,X.length,lookup);
    }
}
