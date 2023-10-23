public class LCS_K_seqence {
    public static int max(int a, int b, int c) {
        return Integer.max(Integer.max(a, b),c);
    }
    public static int LCSLength(String X,String Y,String Z, int m, int n, int o) {
        if (m == 0 || n == 0 || o == 0) {
                return 0;
        }
        if (X.charAt(m-1) == Y.charAt(n-1) &&
                Y.charAt(n-1) == Z.charAt(o-1)) {
            return LCSLength(X, Y, Z, m-1, n-1,o-1);
        }
        return max(LCSLength(X, Y, Z, m-1, n, o),
                LCSLength(X, Y, Z, m, n-1, o),
                LCSLength(X, Y, Z, m, n, o-1));
    }

    public static void main(String[] args) {
        String X = "ABCBDAB", Y = "BDCABA", Z = "BADACB";

        System.out.println(LCSLength(X,Y,Z,X.length(),Y.length(),Z.length()));
    }
}
