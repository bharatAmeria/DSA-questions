// Find all n-digit binary numbers without any consecutive 1’s

public class Ques_37 {
    public static int countStrings(int n, int lastDigit) {
        if(n == 0) {
            return 0;
        }
        if (n == 1) {
            return (lastDigit == 1) ? 1: 2;
        }
        if (lastDigit == 0) {
            return countStrings(n - 1, 0) + countStrings(n-1, 1);
        }else {
            return countStrings(n - 1, 0);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countStrings(n, 0));
        System.out.println(countStrings1(n));
    }

    public static int countStrings1(int n) {
        int[][] T = new int[n+1][2];
        T[1][0] = 2;
        T[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            T[i][0] = T[i-1][0] + T[i-1][1];
            T[i][1] = T[i-1][0];
        }
        return T[n][0];
    }
}
