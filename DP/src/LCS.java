public class LCS {
    public static int LCSLength(String X, String Y, int m, int n) {
        if(m==0 || n==0) {
            return 0;
        }

        if (X.charAt(m-1) == Y.charAt(n-1)) {
            return LCSLength(X,Y,m-1,n-1) + 1;
        }
        return Integer.max(LCSLength(X,Y,m, n-1),
                LCSLength(X,Y,m-1,n));
    }

    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA";
        System.out.println(LCSLength(X,Y, X.length(), Y.length()));
        System.out.println(LCS_Length(X,Y));
    }

    public static int LCS_Length(String X, String Y) {
        int m = X.length(), n = Y.length();

        int[][] t = new int[m+1][n+1];

        for (int i = 0; i <= m ; i++) {
            for (int j = 0; j <= n ; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
            }
                else {
                    t[i][j] = Integer.max(t[i - 1][j], t[i][j - 1]);
                }
        }
    }
        return t[m][n];

}
}
