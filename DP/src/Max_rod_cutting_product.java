public class Max_rod_cutting_product {
    public static int rodCut(int n) {
        int[] t =new int[n +1];

        for (int i = 1; i <= n ; i++) {
            t[i] = i;
        }
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                t[i] = Integer.max(t[i], j*t[i-j]);
            }
        }
        return t[n];
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(rodCut(n));
    }
}
