import java.util.HashMap;
import java.util.Map;

public class ShortestCommonSupersequence {
    public static int SCS(String X, String Y, int m, int n) {
        if (m==0 || n==0) {
            return m+n;
        }
        if (X.charAt(m-1) == Y.charAt(n-1)) {
            return SCS(X,Y,m-1,n-1)+1;
        }
        return Integer.min(SCS(X,Y,m,n-1) + 1,SCS(X,Y,m-1,n) + 1);
    }

    public static void main(String[] args) {
        String X = "ABCBDAB", Y ="BDCABA";
        int m = X.length(), n = Y.length();
        Map<String,Integer> lookup = new HashMap<>();

        System.out.println(SCS(X,Y,m,n));
    }

    public static int SCSLength(String X, String Y, int m, int n, Map<String,Integer> lookup) {
        if (m==0 || n==0) {
            return m+n;
        }
        String key = m + "|" + n;
        if (!lookup.containsKey(key)) {
            if (X.charAt(m-1) == Y.charAt(n-1)) {
                return SCS(X,Y,m-1,n-1)+1;
            }else {
                int min = Integer.min(SCS(X,Y,m,n-1) + 1,SCS(X,Y,m-1,n) + 1);
                lookup.put(key,min);
            }
        }
        return lookup.get(key);
    }
}