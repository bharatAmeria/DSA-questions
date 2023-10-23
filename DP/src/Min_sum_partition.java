import java.util.Arrays;

public class Min_sum_partition {
    public static int findMinAbsDiff(int[] S,int n, int S1, int S2) {
        if (n < 0) {
            return Math.abs(S1 - S2);
        }
        int include = findMinAbsDiff(S, n-1, S1 + S[n], S2);
        int exclude = findMinAbsDiff(S, n-1, S1, S2 + S[n]);
        return Integer.min(include,exclude);
    }

    public static int FindAbsMin(int[] S) {
        int Sum = Arrays.stream(S).sum();
        boolean T[][] = new boolean[S.length + 1][Sum + 1];

        for (int i = 0; i <=S.length; i++) {
            T[i][0] = true;

            for (int j = 0;i>0 && j <= Sum; j++) {
                T[i][j] = T[i-1][j];

                if (S[i-1] <= j) {
                    T[i][j] |= T[i - 1][j - S[i - 1]];
                }
            }
        }
        int j = Sum/2;
        while (j>=0 && !T[S.length][j]) {
            j--;
        }
        return Sum - 2*j;
    }

    public static void main(String[] args) {
        int[] S = {10,20,5,15,25};
        System.out.println(findMinAbsDiff(S,S.length-1,0,0));
        System.out.println(FindAbsMin(S));
    }
}
