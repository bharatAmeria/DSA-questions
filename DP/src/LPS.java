public class LPS {
    public static int LPS(String X,int i, int j) {
        if (i>j) {
            return 0;
        }
        if (i==j) {
            return 1;
        }
        if (X.charAt(i) == X.charAt(j)) {
            return LPS(X, i+1,j-1) +2;
        }
        return Integer.max(LPS(X, i,j-1),LPS(X,i+1,j));
    }

    public static void main(String[] args) {
        String X = "ABBDCACB";
        int n = X.length();
        System.out.println(LPS(X,0,n-1));
    }
}
