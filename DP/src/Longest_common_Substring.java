public class Longest_common_Substring {
    public static String LCS(String X,String Y, int m, int n) {
        int maxLen = 0;
        int endingIndex = m;

        int[][] t = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    t[i][j] = t[i-1][j-1] +1;
                    if (t[i][j] > maxLen) {
                        maxLen = t[i][j];
                        endingIndex = i;
                    }
                }
            }
        }
        return X.substring(endingIndex - maxLen,endingIndex);
    }

    public static void main(String[] args) {
        String X = "ABC", Y = "BABA";
        int m = X.length(), n = Y.length();

        System.out.print("The longest common substring is " + LCS(X, Y, m, n));
    }
}
