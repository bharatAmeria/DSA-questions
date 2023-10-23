public class LCS_Optimised {
    public static int lcs(String X,String Y) {
        int m = X.length();
        int n = Y.length();

        int[] curr = new int[n + 1];
        int[] prev = new int[m + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0 && j > 0) {
                    if (X.charAt(i-1) == Y.charAt(j-1)) {
                        curr[j] = prev[j-1] + 1;
                    }
                    else {
                        curr[j] = Integer.max(prev[j],curr[j-1]);
                    }
                }
            }
            System.arraycopy(curr,0,prev,0,n +1);
        }
        return curr[n];
    }
    public static int LCSLength(String X, String Y) {
        int m = X.length(), n = Y.length();

        int[] curr = new int[n + 1];
        int prev;

        for (int i = 0; i <= m; i++) {
            prev = curr[0];
            for (int j = 0; j <= n; j++) {
                int backup = curr[j];
                if (i == 0 || j == 0) {
                    curr[j] = 0;
                } else {
                    if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                        curr[j] = prev + 1;
                    }
                }
                prev = backup;
            }
        }
        return curr[n];
    }

    public static void main(String[] args) {
        String X = "XMJYAUZ", Y = "MZJAWXU";
        System.out.println(lcs(X,Y));
        if (X.length() > Y.length()) {
            System.out.println("The length of the LCS is " + LCSLength(X, Y));
        }
        else {
            System.out.println("The length of the LCS is " + LCSLength(Y, X));
        }
    }

}
