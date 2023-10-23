import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class max_sum_subMatrix_in_matrix {
    public static int maxSum(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;

        int[][] S = new int[M + 1][N + 1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    S[i][j] = 0;
                } else {
                    S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }
        int maxSum = Integer.MAX_VALUE;
        int rowStart = 0, rowEnd = 0, colStart = 0, colEnd = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int m = 0; m < M; m++) {
                    for (int n = 0; n < N; n++) {
                        int subMatrix_Sum = S[j + 1][n + 1] - S[j + 1][m] - S[i][n + 1] + S[i][m];
                        if (subMatrix_Sum > maxSum) {
                            maxSum = subMatrix_Sum;
                            rowStart = i;
                            rowEnd = j;
                            colStart = m;
                            colEnd = n;
                        }
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = rowStart; i <= rowEnd; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = colStart; j <= colEnd; j++) {
                row.add(matrix[i][j]);
            }
            result.add(row);
        }
        System.out.println(result);
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        { -5, -6, 3, 1, 0 },
                        { 9, 7, 8, 3, 7 },
                        { -6, -2, -1, 2, -4 },
                        { -7, 5, 5, 2, -6 },
                        { 3, 2, 9, -5, 1 }
                };
        System.out.println(maxSum(mat));
    }
}