import java.util.ArrayList;
import java.util.List;

public class max_sum_subMatrix_matrix_1 {
    public static int[][] preprocess(int[][] mat,int M, int N) {
        int[][] sum = new int[mat.length][mat[0].length];
        sum[0][0] = mat[0][0];

        for (int i = 1; i < mat[0].length ; i++) {
            sum[0][i] = mat[0][i] + sum[0][i-1];
        }
        for (int j = 1; j < mat.length; j++) {
            sum[j][0] = mat[j][0] + sum[j-1][0];
        }
        for (int i = 1; i < mat.length; i++) {
            sum[i][0] = mat[i][0] + sum[i-1][0];
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                sum[i][j] = mat[i][j] + sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1];
            }
        }
        return sum;
    }
    public static void SumSubMatrix(int[][] mat, int k) {
        if (mat == null || mat.length == 0) {
            return;
        }
        int M = mat.length;
        int N = mat[0].length;

        int[][] sum = preprocess(mat,M,N);

        int total, max = Integer.MAX_VALUE;

        point p = null;

        for (int i = k-1; i < M; i++) {
            for (int j = k-1; j < N; j++) {

                total = sum[i][j];
                if(i-k >= 0) {
                    total -= sum[i-k][j];
                }
                if (j-k >= 0) {
                    total -= sum[i][j-k];
                }
                if (i-k >= 0 && j-k >= 0) {
                    total += sum[i-k][j-k];
                }
                if (total > max) {
                    max = total;
                    p = new point(i,j);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                int r = i + p.first - k + 1;
                int c = j + p.second - k + 1;
                row.add(mat[r][c]);
            }
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        { 3, -4, 6, -5, 1 },
                        { 1, -2, 8, -4, -2 },
                        { 3, -8, 9, 3, 1 },
                        { -7, 3, 4, 2, 7 },
                        { -3, 7, -5, 7, -6 }
                };
        int k = 3;
        SumSubMatrix(mat,k);
    }

}
class point  {
    int first, second;

    public point(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
