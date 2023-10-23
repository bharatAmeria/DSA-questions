// Count the number of times a pattern appears in a given string as a subsequence
// error int top-down approach
public class Ques_35 {
    public static int count(String X, String Y, int m, int n) {
        if (m == 1 && n==1) {
            return (X.charAt(0) == Y.charAt(0)) ? 1: 0;
        }
        if (m==0) {
            return 0;
        }
        if (n==0) {
            return 1;
        }
        if (n > m) {
            return 0;
        }
        return ((X.charAt(m-1) == Y.charAt(n-1)) ? count(X,Y,m-1, n-1) : 0) + count(X,Y,m-1,n);
    }

    public static void main(String[] args) {
        String X = "subsequence";
        String Y = "sue";
        System.out.println(count(X,Y,X.length(),Y.length()));
        System.out.print(count(X, Y));
    }
    public static int count(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] T = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            T[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                T[i][j] = ((X.charAt(i-1) == X.charAt(j-1)) ? T[i-1][j-1] : 0) + T[i - 1][j];
            }
        }
        return T[m][n];
    }


}
