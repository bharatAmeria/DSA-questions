public class Longest_CS {
    public static String LCS(String a, String b, int m, int n, int[][] lookup) {

        if(m == 0 || n == 0) {
            return new String();
        }
        if (a.charAt(m -1) == b.charAt(n-1)) {
            return LCS(a,b,m-1,n-1,lookup) + a.charAt(m-1);
        }
        if (lookup[m-1][n] > lookup[m][n-1]) {
            return LCS(a,b,m,n-1,lookup);
        }else {
            return LCS(a,b,m,n-1,lookup);
        }
    }
    public static void LCSLength(String a,String b,int m, int n,int[][] lookup) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    lookup[i][j] = lookup[i-1][j-1]+1;
                }
                else {
                    lookup[i][j] =  Integer.max(lookup[i-1][j], lookup[i][j-1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        String a = "XMJYAUZ", b = "MZJAWXU";
        int m = a.length(), n = b.length();

        int[][] lookup = new int[m + 1][n + 1];
        LCSLength(a,b,m,n,lookup);
        System.out.println(LCS(a,b,m,n,lookup));
    }
}
