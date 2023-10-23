public class Longest_palindromic_subseq {
    public static void main(String[] args) {
        String X = "ABBDCACB";
        int n = X.length();

        System.out.print("The length of the longest palindromic subsequence is "
                + LPS(X, 0, n - 1));
    }
    public static int LPS(String X, int m, int n) {
        if (m > n) {
            return 0;
        }
        if (m == n) {
            return 1;
        }
        if (X.charAt(m) == X.charAt(n)) {
            return LPS(X, m+1, n+1 ) + 2;
        }
        return Integer.max(LPS(X,m,n-1),LPS(X,m+1,n));
    }
}
