public class sumOfAllEle_in_cons_time {
    public static void main(String[] args) {
        int[][] mat =
                {
                        { 0, 2, 5, 4, 1 },
                        { 4, 8, 2, 3, 7 },
                        { 6, 3, 4, 6, 2 },
                        { 7, 3, 1, 8, 3 },
                        { 1, 5, 7, 9, 4 }
                };
        int p = 1, q = 1, r = 3, s = 3;
        System.out.println(subMatrixSum(mat,p,q,r,s));
    }


    public static int[][] preprocess(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int[][] sum = new int[mat.length][mat[0].length];
        sum[0][0] = mat[0][0];

        for (int i = 1; i < mat[0].length; i++) {
            sum[0][i] = mat[0][i] + mat[0][i - 1];
        }
        for (int j = 1; j < mat.length; j++) {
            sum[j][0] = mat[j][0] + mat[j - 1][0];
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                sum[i][j] = mat[i][j] + sum[i - 1][j] +
                        sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        return sum;
    }

    public static int subMatrixSum(int[][] mat, int p, int q, int r, int s) {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int[][] sum = preprocess(mat);

        int total = sum[r][s];

        if (q - 1 >= 0) {
            total -= sum[r][q - 1];
        }

        if (p - 1 >= 0) {
            total -= sum[p - 1][s];
        }

        if (p - 1 >= 0 && q - 1 >= 0) {
            total += sum[p - 1][q - 1];
        }
        return total;
}

}
