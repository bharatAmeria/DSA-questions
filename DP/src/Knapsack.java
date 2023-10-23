public class Knapsack {

    public static int knapSack(int wt[], int val[], int w, int n) {
        if (n < 0 || w == 0) {
            return 0;
        }
        if (w < 0) {
            return Integer.MIN_VALUE;
        }
        int include = val[n] + knapSack(wt, val, w - wt[n], n-1);
        int exclude = knapSack(wt, val, w, n -1);
        return Integer.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] val = {20, 5, 10, 40, 15, 25};
        int[] wt = {1, 2, 3, 8, 7, 4};

        int w = 10;
        System.out.println("Knapsack value is " + knapSack(wt, val, w, val.length - 1 ) );
    }
}
