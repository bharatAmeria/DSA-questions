public class Find_min_of_deletions_to_make_palindrome {

    public static int minDeletions(String X, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (X.charAt(i) == X.charAt(j)) {
            return minDeletions(X,i+1,j-1);
        }
        return 1 + Math.min(minDeletions(X,i,j-1), minDeletions(X, i+1, j));
    }
//    method 2
    public static int minDeletions(String X) {
        String Y = new StringBuilder(X).reverse().toString();

        int n = X.length();

        int[][] lookup = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lookup[i][j] = lookup[i - 1][j - 1] + 1;
                } else {
                    lookup[i][j] = Math.max(lookup[i - 1][j], lookup[i][j - 1]);
                }
            }
        }
        return n - lookup[n][n];
    }

    public static void main(String[] args) {
        String X = "ACBCDBAA";
        int n = X.length();

        System.out.println(minDeletions(X,0,n-1));
        minDeletions(X);
    }
}
